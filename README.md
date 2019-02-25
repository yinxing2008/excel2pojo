# 功能介绍
将excel定义的字段转化为java(kotlin) bean定义
excel定义的字段类型样例：
| 名称      | 类型   | 是否必须 | 默认值 | 备注 |
| --------- | ------ | -------- | ------ | ---- |
| name      | string |          |        | 名称 |
| itemCount | number |          |        | 数量 |

1. 生成kotlin bean样例：
```
/**
* 名称
*/
var name: String? = null
/**
* 数量
*/
var itemCount: BigDecimal? = null
```
2. 生成java bean样例：
```
/**
* 名称
*/
public String name;
/**
* 数量
*/
public BigDecimal itemCount;
```

# 定制介绍
参考KotlinExcelListener或JavaExcelListener定制输出格式

# 使用
1. 将字段定义存入excel文件，修改Parser类中filePath为excel文件格式（注意excel应该是2007格式，后缀为xlsx）
2. 运行Parser类，完成后，就会将生成的bean信息打印在终端并复制到剪贴板。