# API

###获取二维码

```
GET /classroom/code
```

参数

```
String id:"设备id"
```

返回案例

```
{
    "code":0,
    "msg":"成功",
    "data":{
            "codeId":20,
            "codeUrl":"C:\\apache-tomcat-8.5.20\\webapps\\img测试.jpg",
            "cid":"测试"
            }
 }
```

###生成文档

```
POST /classroom/uploadimg
```

参数

```
MultipartFile file:"图片文件"
String id:"设备id"
```

返回

```

```
###创建课程

```
POST /classroom/classes/creat
```

参数

```
MultipartFile file:"图片文件"
String openId
String lessonName
```

返回

```

```
###更新课程头像

```
POST /classroom/classes/upload
```

参数

```
MultipartFile file:"文件"
String openId,
int lessonId
```

返回

```

```
###获取我上传的课程资料

```
GET /classroom/classes/getAll
```

参数

```
String openId
```

返回

```

```
###获取某门课程的所有课程资料

```
GET /classroom/classes/getOne
```

参数

```
String openId
int lessionId
```

返回

```

```
###教师微信小程序注册

```
GET /wechat/userCreat
```

参数

```
String code
String headurl
String nickname
```

返回

```

```
###学生微信小程序注册

```
GET /wechat/studentCreat
```

参数

```
String code
String headurl
String nickname
```

返回

```

```
###微信公众号用户注册

```
GET /wechat/registered
```

参数

```
String code
```

返回

```

```
###学生微信小程序完善身份信息

```
POST /classroom/student/idcard
```

参数

```
HttpServletRequest request
String phone
String openid
String avatarUrl
String nickname
int userId
```

返回

```

```
###教师微信小程序完善身份信息

```
POST /classroom/user/idcard
```

参数

```
HttpServletRequest request
String phone
String openid
String avatarUrl
String nickname
int userId
```

返回

```

```
###签到

```
GET /classroom/sign/creat
```

参数

```
int id
String date
int studentId
int lessonId
String time
```

返回

```

```
###查询签到

```
GET /classroom/sign/select
```

参数

```
String date
int lessionId
```

返回

```

```
###上传课程资源

```
GET /classroom/resources/creat
```

参数

```
int lessonId 
File file
```

返回

```

```
###学生学习某门课程

```
GET /classroom/lession/add
```

参数

```
int studentId
String lessonName
```

返回

```

```
###查询学生所有课程

```
GET /classroom/lession/select
```

参数

```
int studentId
```

返回

```

```
###查询某个课程的资源

```
GET /classroom/resources/select
```

参数

```
int lessonId
```

返回

```

```
###分发任务

```
GET /classroom/task/create
```

参数

```
int teacherId
int lessonId
String taskName
String taskTime
```

返回

```

```
###提交任务

```
POST /classroom/homework/create
```

参数

```
int studentId
int lessonId
int taskId
String text
String file
MultipartFile file
```

返回

```

```
###任务情况统计

```
GET /classroom/task/select
```

参数

```
int taskId
```

返回

```

```