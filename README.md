# 软件库后台管理系统

欢迎使用 **软件库后台管理系统**，这是一个使用 Spring Boot 构建的强大而可扩展的后端解决方案，专为管理软件下载网站的软件库而设计。

## 功能特性

- **用户管理**：轻松管理用户账户，包括角色和权限，以控制访问级别。
- **软件目录**：详细记录每个软件的信息，包括版本历史、发布说明和下载链接。
- **下载追踪**：追踪每个软件的下载统计，了解用户偏好和软件受欢迎程度。
- **分类与标签**：将软件分类到不同的类别，并应用标签以简化导航和搜索。
- **用户友好的界面**：为管理员提供直观且响应迅速的网页界面，以便高效地管理软件库。

## 入门指南

### 先决条件

- [Java开发工具包（JDK）](https://www.oracle.com/java/technologies/javase-downloads.html)
- [Maven](https://maven.apache.org/download.cgi)
- [MySQL](https://www.mysql.com/downloads/) 数据库

### 安装

1. 克隆仓库：

   ```bash
   git clone https://github.com/your-username/software_library.git
   ```

2. 进入项目目录：

   ```
   bashCopy code
   cd software_library
   ```

3. 在 `src/main/resources/application.properties` 中使用你的MySQL数据库凭据更新数据库配置：

   ```
   propertiesCopy codespring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   ```

4. 构建并运行项目：

   ```
   bashCopy codemvn clean install
   java -jar target/software-library-backend-1.0.0.jar
   ```

5. 在 http://localhost:8080 访问系统



## 使用

1. **登录**：使用管理员凭据登录系统。
2. **管理软件**：添加、编辑或删除软件条目。提供详细信息，如版本历史、发布说明和下载链接。
3. **用户管理**：通过管理用户账户和角色来控制用户访问。



