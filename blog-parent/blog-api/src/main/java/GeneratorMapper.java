import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

public class GeneratorMapper {

    public static void main(String[] args) {
        //  创建AutoGenerator，Mp中对象
        AutoGenerator autoGenerator = new AutoGenerator();

        //  设置全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        //  设置代码的生成位置，磁盘的目录
        //  当前用户所在的项目目录
        String path = System.getProperty("user.dir");
        globalConfig.setOutputDir(path + "/blog-parent/blog-api/src/main/java");
        //  设置生成的类的名称（命名规则）
        //  %s表示数据库中的表
        //  所有的Dao类都是Mapper结尾的，例如DeptMapper
        globalConfig.setMapperName("%sMapper");
        //  DeptService，设置Service接口的名称
        globalConfig.setServiceName("%sService");
        //  DeptServiceImpl，设置Service实现类的名称
        globalConfig.setServiceImplName("%sServiceImpl");
        //  DeptController，设置Controller类的名称
        globalConfig.setControllerName("%sController");
        //  设置开发的作者
        globalConfig.setAuthor("xiaokou");
        //  设置主键id的配置(自动增长，雪花，UUID等)
        //  如果数据库已经设置自动增长，就按数据库的来
        globalConfig.setIdType(IdType.ASSIGN_ID);

        autoGenerator.setGlobalConfig(globalConfig);


        //  设置数据源
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        //  驱动
        dataSourceConfig.setDriverName("com.mysql.cj.jdbc.Driver");
        //  设置url
        dataSourceConfig.setUrl("jdbc:mysql://localhost:3306/blog?useUnicode=true&characterEncoding=utf-8&serverTimezone=UTC");
        //  设置数据库的用户名
        dataSourceConfig.setUsername("root");
        //  设置密码
        dataSourceConfig.setPassword("12345");
        //  把DataSourceConfig赋值给AutoGenerator
        autoGenerator.setDataSource(dataSourceConfig);


        //  设置package信息
        PackageConfig packageConfig = new PackageConfig();
        //  设置模块的名称，相当于包名，在这个包的下面有mapper、service、controller
        packageConfig.setModuleName("blog");
        //  设置父包名， order 就在父包的下面生成
        packageConfig.setParent("com.kou");

        autoGenerator.setPackageInfo(packageConfig);


        //  设置策略
        StrategyConfig strategyConfig = new StrategyConfig();
        //  设置支持驼峰的命名规则
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);
        //  去掉表名前缀
        strategyConfig.setTablePrefix("ms_");
        //  是否生成Lombok注解
        strategyConfig.setEntityLombokModel(true);
        //  设置命名规则下划线转驼峰
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);

        autoGenerator.setStrategy(strategyConfig);


        //  执行代码的生成
        autoGenerator.execute();
    }
}
