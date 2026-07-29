# 权限判定模块

## API

`POST /auth/permission?url=<path>&method=<HTTP_METHOD>`：根据已认证用户名、目标 URL 和 HTTP 方法返回布尔判定结果。请求必须携带可验证的 OAuth JWT。

## 关键组件

- `AuthenticationController`：权限判定入口。
- `AuthenticationService`：匹配 URL 所需资源和用户资源。
- `ResourceService`：加载并缓存资源定义。
- `ResourceProvider`：调用 Organization 的 `/resource/all` 与 `/resource/user/{username}`。
- `BusReceiver`：处理资源更新通知并刷新缓存。

未登记 URL 使用 `NONEXISTENT_URL` 标记并拒绝。排障时检查 JWT 验证、Organization 可用性、资源 code、用户角色授权和本地缓存刷新。
