# unix

## 基础

```shell
三个重要组成
1，kernel 内核
内核，管理硬件设备、内存、进程、交互空间、文件系统、系统程序等。
2,shell 
命令先传到shell，然后在将这个指令翻译成计算机可以识别的二进制语言，然后传给计算机内核，
3,File System
文件系统，将硬件和软件都映射成文件，统一进行管理。

权限
- 文件
d 目录
l 连接文件
b 块设备文件
c 字符设备文件
p 命令管道文件
s sock文件
rw-rw-r-- 分别为拥有者权限、同组人权限、其他人权限
chmod u+x b.txt
u 表示拥有者
g 表示同组人
o 表示其他人
a 表示所有人

vi编辑器有三种模式，命令模式，命令行模式，编辑模式
1，命令模式，可以使用简单的命令进行文本内容的操作
2，命令行模式，可以使用复杂点的命令进行文本内容操作
3,编辑模式，可以直接编辑文本内容

vi编辑器
i 表示在光标当前位置处插入，并变为编辑模式
a 表示在光标所在位置后插入，并变为编辑模式
o 表示在光标所在行的下方插入空行，并变为编辑模式
```

当前目录
```shell
.
```

上级目录

```shell
..
```

查看默认使用的shell

```shell
echo $SHELL
```
查看用户当前使用的shell

```shell
ps
```
普通用户修改密码

```shell
passwd
```

提升权限

```shell
sudo
```

设置root用户密码

```shell
sudo passwd root
```

切换到root用户

```shell
su
```

回到普通用户

```shell
exit
```

新建用户

```shell
sudo useradd -mk /home/swift -s /bin/bash swift
```

给新建的用户设置密码

```shell
sudo passwd swift
```

切换到swift用户

```shell
su - swift
```

查看所属组

```shell
id
```

将用户swift添加到sudo组中

```shell
sudo gpasswd -a swift sudo
```

将sudo组从用户swift删除

```shell
sudo gpasswd -d swift sudo
```

删除swift用户，并删除swift用户对于的家目录 /home/swift，并且是强制删除

```shell
sudo userdel -r -f swift
```

显示当前所在目录

```shell
pwd
```

切换目录

```shell
cd
```
列出文件列表

```shell
ls
ls -a  显示出所有文件
ls -l  ll
```
创建目录

```shell
mkdir 
mkdir -p test1/test2/test3 创建多级子目录，-p表示如果子目录不存在就创建
```
移除目录

```shell
rmdir
```

创建一个空文件

```shell
touch
touch a.txt
```

浏览文件

```shell
cat	显示文件内容
more	画面过长 空格翻页回车显示下行数据
b，每次向上翻回一页
f， 每次向下翻一页
q，退出当前查看内容界面
v，进入vi模式（只读）


less	同more PgUp/PgDn翻页
tail -10 /etc/passwd    查看后10行数据 
tail -f catalina.log    动态查看日志
```

删除文件

```shell
rm 
rm -f a.txt    不询问，直接删除rm 删除目录
rm -r a    删除非空目录 递归删除不询问递归删除（慎用）删除目录 
rm -rf  a    不询问递归删除非空
rm -rf *      删除所有文件
rm -rf /*      自杀
rm -i a.txt 删除前确认
```

权限

```shell
chmod u+x b.txt
chmod g-r b.txt
chmod u+r,g-2 b.txt
chmod a=rw b.txt

```

复制命令

```shell
cp a.txt b.txt    将a.txt复制为b.txt文件
cp a.txt ../    将a.txt文件复制到上一层目录中
cp -i a.txt b.txt -i 是否覆盖
cp -r test1 test2 复制文件夹和它的内容，到另一个文件夹中
cp -r test test4/temp 把test目录复制到test4目录中，并且修改目录名字为temp
```

移动或者重命名

```shell
mv a.txt ../    将a.txt文件移动到上一层目录中
mv a.txt b.txt    将a.txt文件重命名为b.txt
mv -i a.txt b.txt 覆盖提示
```

打包

```shell
tar
-c：创建一个新tar文件
-v：显示运行过程的信息
-f：指定文件名
-z：调用gzip压缩命令进行压缩
-t：查看压缩文件的内容
-x：解开tar文件

打包：
tar –cvf xxx.tar ./*
打包并且压缩：
tar –zcvf xxx.tar.gz ./* 
解压 
     tar –xvf xxx.tar
	 tar -zxvf xxx.tar.gz -C /usr/aaa

```

查找符合条件的文件

```shell
find
find / -name “ins*” 查找文件名称是以ins开头的文件
find / -name “ins*” –ls 
find / –user itcast –ls 查找用户itcast的文件
find / –user itcast –type d –ls 查找用户itcast的目录
find /-perm -777 –type d-ls 查找权限是777的文件
```

查找文件里符合条件的字符串

```shell
grep
grep [选项]... PATTERN [FILE]...示例：
grep lang anaconda-ks.cfg  在文件中查找lang
grep lang anaconda-ks.cfg –color 高亮显示
```

**软连接**（快捷方式）

```shell
ln -s /home/briup/.bigdata/softwares/jdk1.8.0_212/ jdk
```

**关机**

```
sudo poweroff
```

**重启**

```
sreboot
```



## 特殊字符

```shell
* 表示通配，可以代表0~n个字符
? 表示任意字符
;表示在一行语句中连续执行多个命令，命令之间使用分号进行分割
>  输出重定向 覆盖
>>  输出重定向 续写
| 管道符，可以把第一个命令的结果，交给第二个命令作为参数进行操作
cat /etc/passwd | grep "briup"
```

黑洞文件

```
/dev/null
```



## vi编辑器

i 表示在光标当前位置处插入，并变为编辑模式 

a 表示在光标所在位置后插入，并变为编辑模式 

o 表示在光标所在行的下方插入空行，并变为编辑模式

命令模式

命 令    作用 

x           删除一个字符 

dw	   删除一个单词 

3dw     删除3个单词 

dd        删除一行，光所在行 

2dd      删除2行，光标所在行和下一行 

r           替换一个字符，在某个字符上按r，然后再按另一个新字符，这样新字符就会替换原来的老字符 

cw        先删除这个单词，再进入到编辑模式 

cc          先删除当前行，再进入到编辑模式 C 大写C（shift+c）,删除光标所在位置到当前行的末尾，然后进入编辑模式

yy         复制当前行 

yw        复制一个单词 

p 		 粘贴复制的内容 ~ shift+~，把字符进行大小写转换 J shift+j，把当前行和下一行进行连接 

u		 撤销之前的操作 

G 		shift+g，将光标定位到文件末尾 

nG 	将光标定位到文件第n行，这里n代表的是行号 /hello 查找和hello的位置，然后使用n可以定位到下一个匹配的地方，从上往下查找 ?test 查找和test的位置，然后使用n可以定位到下一个匹配的地方，从下往上查找 将把光标移动到下一个字的字尾 

w        将光标移至下一个字的字首 

b		将光标移至上一个字的字首 

h 		将光标左移 

l 		将光标右移 

j 		将光标下移 

k	    将光标上移

命令行模式

:2,4d 	删除第2行到第4行 

:2,4co5 	拷贝第2行到第4行之间的内容到第5行后面 

:1,2m7 	移动第1行到第2行之间的内容到第7行后面 

:w 	保存 

:w 	newfile 保存为另一个新文件，相当于另存为功能 

:q 	退出 

:q! 	强制退出 

:wq!	保存并强制退出

:set nu 	显示行号，set nonu 是取消行号 

:5 	将光标直接定位到第五行 

:r b.txt 	将b.txt文件内容插入到当前文件中 

:1,$s/hello/test/g 	将文件中从1行开始，所有的hello替换成test

## 环境变量

用户级别

在~/.bashrc中配置 

系统级别

在/ect/profile中配置rm

先退回到bash中，使用vi打开.bashrc进行修改： vi .bashrc

在这个实验操作中，一定要理解 source  .bashrc 生效命令和 export 导出给所有子环境  起到的作用

# 搭建服务器

































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































