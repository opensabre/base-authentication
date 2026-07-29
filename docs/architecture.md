# 架构与鉴权流程

1. 调用方携带 OAuth JWT 请求 `POST /auth/permission`，同时传入目标 `url` 与 `method`。
2. Resource Server 使用共享 signing key 验证 JWT，建立 Spring Security Authentication。
3. `ResourceService` 从 Organization 资源接口加载全局资源和用户资源，并通过 JetCache 缓存。
4. `AuthenticationService` 将 URL/HTTP 方法映射为资源 code，再与用户资源集合匹配。
5. URL 未登记或资源不匹配时返回无权限。

资源变更通过 RabbitMQ Bus 通知刷新缓存。此模型是集中式权限判定，不是 Framework 0.7 的逐跳内部 Token 认证。
