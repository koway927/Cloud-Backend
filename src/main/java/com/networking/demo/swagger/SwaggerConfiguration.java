//package com.networking.demo.swagger;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.Contact;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//@Configuration
//@EnableSwagger2
////swagger是需要配置的
////复制粘贴配置文件即可。
////为java mvc框架集成swagger生成api文档 增强解决方案。
////前身是swagger。前身swagger-bootstrap-ui 取名kni4j是希望它能像一把匕首一样小巧，轻量，并且功能强悍。
////swagger可以在线调试api。
////knife4j可以离线文档。个性化配置。
//
////app端网关。
////授权 登录 限流 日志。 网关然后才有微服务。
////做一个过滤。做路由操作。
////
//public class SwaggerConfiguration {
//
//   @Bean
//   public Docket buildDocket() {
//      return new Docket(DocumentationType.SWAGGER_2)
//              .apiInfo(buildApiInfo())
//              .select()
//              // 要扫描的API(Controller)基础包
//              .apis(RequestHandlerSelectors.basePackage("com.heima"))
//              .paths(PathSelectors.any())
//              .build();
//   }
//
//   private ApiInfo buildApiInfo() {
//      Contact contact = new Contact("黑马程序员","","");
//      return new ApiInfoBuilder()
//              .title("黑马头条-平台管理API文档")
//              .description("黑马头条后台api")
//              .contact(contact)
//              .version("1.0.0").build();
//   }
//}