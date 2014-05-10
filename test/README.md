JadeBeanFactoryPostProcessor
    配置在发布包下的applicationContext-jade.xml中，
    Spring容器完成其内部的标准初始化工作后将调用本处理器，
    识别符合Jade规范的 DAO 接口并将之配置为Spring容器的Bean定义，加入到Spring容器中。

    开关属性的设置
        jade在发布jar包时，将在发布包下的applicationContext-jade.xml
        文件配置本处理器（也就说本类一定会被Spring容器执行），
        为使jade能够适应不同的应用环境和业务需要，jade特提供了一些系统属性设定约定，
        使得您可灵活地控制本处理器的行为，甚至将本处理器视为一个空处理器：

        1. jade.context.spring
            如果设置了一个非空属性值(非空时应该填写什么值Jade不做规定)，
            表示jade的spring初始化工作不由本类负责。
            所以，如果您觉得jade默认去自动扫描DAO接口并注册到Spring容器的行为是您不愿接受，
            您可以设置一个非空值给该属性，从而叫停jade的这个行为。

        2. jade.context.spring.com.yourcompany.dao.UserDAO
            合法的值：0表示忽略，1表示肯定；除0和1外的设置（包括空值）都是非法的。
            在jade的spring初始化工作由本类负责的前提下，
            将该属性设置为0表示该DAO不由本类负责读取并放到Spring容器中（即忽略之）；
            设置为1则表示该DAO由本类负责读取并放到Spring容器中（即肯定之）。

            如果没有该系统属性，jade则读取它的上一级属性：jade.context.spring.com.yourcompany.dao
            并以此类推，直至 jade.context.spring.*。这类属性在Jade统称为开关属性。

        3. jade.context.spring.*
            这个属性是所有开关属性的根，即类似 jade.context.spring.com 和 jade.context.spring.cn
            之类的开关属性，它的父亲是 jade.context.spring.*, 而非 jade.context.spring
            如果没有设置这个根属性，jade 将等价于其被设置为1。您可以将之设置为0，
            这样就表示只有那些明确设置了开关属性为1的package或接口的类才由本处理器负责读取并放到Spring容器中。

    DAO的发现
        首先，本处理器会调用 {@link RoseScanner#getJarOrClassesFolderResources()}
        获取类路径下的classes目录以及那些设置了rose标帜的jar包地址。
        (为了使jar包中的DAO能够被本处理器识别，其设置的rose标识中必须含有dao或DAO。)

        然后，本处理器将从classes目录或jar包中识别那些符合jade规范的DAO接口：
            1. DAO接口的package必须含有dao目录，如：
                dao.UserDAO、myapp.dao.UserDAO、myapp.dao.blog.BlogDAO
            2. DAO接口必须以大写DAO结尾，如：UserDAO、BlogDAO
            3. DAO接口上必须标注@DAO注解
            （Jade在实现上通过读取二进制文件来进行判断，而非Class.forName）

        通过这两个步骤，本处理器完成了对DAO接口的发现，并最后将这些接口封装为 {@link JadeFactoryBean}
        的形式注册到Spring容器中。

    数据源
        数据源{@link DataSource}提供了数据库的访问接口，jade通过{@link DataSourceFactory}
        接口为DAO方法提供数据源，在本处利器所初始化的spring容器中，数据源的设置有两种方式：

        定制方式
            当spring容器配置了一个id/name 为 "jade.dataSourceFactory"对象，
            jade将把这个bean取出来，作为 {@link DataSourceFactory}为DAO提供数据源；

            当spring容器没有id/name 为 "jade.dataSourceFactory"的对象，
            但是配置其它名字的{@link DataSourceFactory}，
            jade将把这个bean 取出来，为DAO提供数据源；

            当spring容器没有id/name 为 "jade.dataSourceFactory"的对象，
            但其中存在{@link DataSourceFactory}的个数超过1个，
            此时系统初始化的时侯不会跑出异常，但一旦开始进行进行DAO操作时，
            将抛出IllegalStateException 异常。（参见 {@link SpringDataSourceFactoryDelegate}）

        默认方式
            当spring容器没有配置任何 {@link DataSourceFactory} 时，
            jade将启用默认方式为DAO配置数据源，即使用{@link SpringDataSourceFactory}
            为DAO提供数据源，从spring容器中寻找对应的数据源。

        对于给定的一个DAO接口，如com.mycompany.myapp.dao.UserDAO, 其规则如下：
            如果存在id/name为jade.dataSource.com.mycompany.myapp.dao.UserDAO的数据源，
            则使用它作为这个DAO的数据源，否则逐级询问配置，直到顶一级包名：jade.dataSource.com

            如果以上仍未能确定UserDAO的数据源，且UserDAO接口上的<code>@DAO</code>
            的catalog属性非空（假设其值为myteam.myapp），
            则视myteam.myapp等同于package名，执行前一个步骤的问询
            即按此顺序问询Spring容器的配置：
                jade.dataSource.myteam.myapp.UserDAO，...，jade.dataSource.myteam

            如果以上仍未能确定UserDAO的数据源，
            则判断是否存在id/name为jade.dataSource、dataSource的数据源

            如果以上仍未能确定UserDAO的数据源，则最终就是没有数据源，运行时将会有异常抛出

    SQL解析器
        当DAO方法被调用，执行数据库访问前，jade总是会先调用相应的SQL解析器，
        解析/改写SQL、设置相应的参数或运行时状态。

        Jade使用 {@link InterpreterFactory} 为每个DAO方法配置对应的解析器。
        本处理器使用的{@link InterpreterFactory} 是 {@link SpringInterpreterFactory}。
        {@link SpringInterpreterFactory}将获取配置在Spring容器中的 {@link Interpreter}
        ，按照标注在其上的{@link Order}排序，设置给各个DAO方法。