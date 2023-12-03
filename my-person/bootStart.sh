#!/bin/sh
#记事本打开，修改编码格式为utf8，可解决上传centos后中文乱码问题
echo =================================
echo  镜像容器更新
echo =================================
echo 准备从Git仓库拉取最新代码
cd /root/temp/deploy-code-to-102-machines
echo 开始从Git仓库拉取最新代码
git pull
echo 代码拉取完成
echo 开始打包
cd /root/temp/deploy-code-to-102-machines/my-person
output=`mvn clean install -Dmaven.test.skip=true`
# 切换到docker目录
cd /root/temp
echo 停止并删除相关容器
output=`docker-compose down`
echo 更新镜像,并启动容器
output=`docker-compose up --build -d`
echo 项目启动完成




































