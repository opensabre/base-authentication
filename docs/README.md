# base-authentication 文档索引

`base-authentication` 是历史资源鉴权服务，提供基于外部 OAuth JWT 和组织资源表的权限判定。当前代码仍使用旧版 Spring Security OAuth、`javax.servlet` 和历史父工程依赖，不属于 OpenSabre Framework 0.7 服务间内部 Token 方案。

- [架构与鉴权流程](architecture.md)
- [开发、配置与安全注意事项](development.md)
- [权限判定模块](modules/permission-decision.md)

新系统优先使用当前网关、授权服务与 Framework 0.7 安全组件；维护本项目时不得把历史 JWT 签名配置复制到新环境。
