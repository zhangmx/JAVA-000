## 题目

自定义一个Classloader，加载一个Hello.xlass文件，执行hello方法，此文件内容是一个Hello.class文件所有字节(x=255-x)处理后的文件。文件群里提供

## 工具说明

fileconvert.jar 是一个处理文件的工具(参考？)
Hello.zip 目标文件
FileConvert.exe 没用到

## 需求

- [x] 加载 xlass文件
- [x] 对文件内容解密
- [x] 解密内容作为类加载器的参数，执行加载
- [x] 运行里面的方法 hello

