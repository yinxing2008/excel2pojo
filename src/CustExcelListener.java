import java.util.List;

/**
 * 可根据实际需要修改输出的数据格式
 */
public class CustExcelListener extends BaseExcelListener {

    public CustExcelListener() {
        typeMap.put("number", "Decimal");
        typeMap.put("integer", "int");
        typeMap.put("string", "String");
    }

    protected String processRow(List list) {
        StringBuffer sb = new StringBuffer();
        int colNameIndex = 0;
        int colTypeIndex = 1;
        int colDescIndex = 4;

        sb.append("/**").append(NEW_LINE)
                .append("*").append(list.get(colDescIndex)).append(NEW_LINE)
                .append("*/").append(NEW_LINE);

        sb.append("public")
                .append(" ").append(getMappedType(list.get(colTypeIndex).toString()))
                .append(" ").append(list.get(colNameIndex))
                .append(";").append(NEW_LINE);
        return sb.toString();
    }

}
