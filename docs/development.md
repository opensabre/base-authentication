# 开发、配置与安全注意事项

服务名 `authentication-server`，默认端口 8001；依赖 Nacos、Redis、RabbitMQ 和 Organization 资源接口。

历史 `application.yml` 包含演示 signing key 和本地数据库口令，仅供旧环境参考，生产部署必须通过外部密钥管理覆盖，严禁复用示例值。当前 Maven 父工程与部分依赖不在本仓库，独立构建前需先确认历史聚合工程。

常用命令：`mvn test`、`mvn spring-boot:run`。原 README 的 `mvn docker:build` 使用旧 Spotify 插件，执行前需确认 Docker 环境和镜像仓库配置。

迁移到 0.7 时，应由网关校验外部 JWT，首应用完成接口授权后签发内部 Token；不要把本服务的共享 JWT signing key 当作内部 Token active key。
