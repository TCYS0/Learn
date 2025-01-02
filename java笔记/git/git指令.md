# git指令

## 用户操作

```shell
#用于输出git提交日志
alias git-log='git log --pretty=oneline --all --graph --abbrev-commit'
#用于输出当前目录所有文件及基本信息
alias ll='ls -al'

# 使用可以查看现在的git环境详细配置
git config -l

#查看系统config
git config --system --list

#查看当前用户（global）配置
git config --global --list

#查看当前仓库配置信息
git config --local --list

# 设置名称
git config --global user.name "briup"

# 设置邮箱
git config --global user.email "briup@qq.com"

#用户删除数据
git config [--local|--global|--system] --unset section.ke
```

## 项目操作

```shell
#设置项目名称和邮箱
git config user.name  "fuhao7"
git config user.email "fuhao7@asiainfo.com"

#初始化数据库
git init;

# 新建一个目录，将其初始化为Git代码库
git init [project-name]

# 克隆一个远程仓库到本地
git clone [url]
```

## 文件操作

```shell
# 查看指定文件状态
git status [filename]

# 查看所有文件状态
git status

# 执行添加命令，将readme.txt文件添加到 staged暂存区
git add readme.txt
# git add readme.txt 提交指定文件
# git add . 把当前所有变化提交到暂存区,不包括删除文件
# git add --all 把当前所有变化提交到暂存区,包括删除文件

# 将暂存区的readme文件进行commit提交
git commit -m 'create new file readme'

# 在文件已修改的状态下,如果恢复之前的内容。执行
git checkout 

# 这不是git特定的，它是一个通用的Unix命令行约定
git checkout -- readme.txt

# 直接从暂存区删除文件，保留工作区的物理文件
git rm readme.txt --cached

# 不但从stage中删除，同时删除物理文件，前提是该文件已经提交到版本库中
git rm readme.txt

# 额外了解git reset HEAD，是将当前暂存区的改变[取消]，回复到改变之前,rm命令是[删除]
git reset HEAD readme.txt

# 查看操作日志，可以查看提交的用户、时间及提交信息
git log
```

## 仓库操作

```shell
#查看远程仓库
git remote -v

#添加远程仓库
git remote add origin url

#修改远程仓库
git remote set-url origin url

#删除远程仓库
git remote remove origin

#推送给远程仓库
git push -u origin master

#使用一次即可直接push
git push

#拉取远程仓库中最新修改的内容
git pull

#也可以在本地修改文件内容，提交并推送给远程仓库：
git add . && git commit -m 'modify readme' && git push
```



## 分支操作

```shell
#查看分支
git branch

#查看所有分支（远程）
git branch -a

#创建分支
git branch dev

#切换分支
git checkout dev

#合并分支在master分支中，将dev分支的改动合并过来
git merge dev

#删除分支
git branch -d dev

#新建分支并切换
git checkout -b dev-bug01

#推送到远程仓库
git push -u origin dev-bug01

#在master分支上推送远程分支
git push origin dev-bug01:dev-bug01

#查看最近一次提交
git commit --amend
```

