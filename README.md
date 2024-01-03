项目说明
======
指定项目编译可以使用以下命令
cd spring-cloud
spring-cloud>mvn install -pl project-name #多项目用“,"分割

| 项目                      | 端口   | 介绍       |
|:------------------------|:-----|:---------|
| microservice-rest-movie | 8001 | movie微服务 |
| microservice-rest-user  | 8002 | user微服务  |
| microservice-gateway    | 8000 | 网关       |
			
			
			
mongo用户配置
===
```shell
$ docker exec -it spring-cloud-mongodb-1 mongosh admin
#用户授权，使用mongo容器用户配置
#      - MONGO_INITDB_ROOT_USERNAME=admin
#      - MONGO_INITDB_ROOT_PASSWORD=123456
admin> db.auth("admin","123456")
#切换到业务数据库
admin> use movies
#添加用户
movies> db.createUser({
... user:"spring_cloud",pwd:"123456",
... roles:[{role:"readWrite",db:"movies"}]
... })

```


			
			
			
			
			
