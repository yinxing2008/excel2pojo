import java.util.List;

/**
 * 可根据实际需要修改输出的数据格式
 */
public class KotlinExcelListener extends BaseExcelListener {

    public KotlinExcelListener() {
        typeMap.put("number", "BigDecimal");
        typeMap.put("integer", "Int");
        typeMap.put("string", "String");
    }

    protected String processRow(List list) {
        StringBuffer sb = new StringBuffer();
        int colNameIndex = 0;
        int colTypeIndex = 1;
        int colDescIndex = 4;

        sb.append("/**").append(NEW_LINE)
                .append("* ").append(list.get(colDescIndex)).append(NEW_LINE)
                .append("*/").append(NEW_LINE);
        sb.append("var")
                .append(" ").append(list.get(colNameIndex))
                .append(": ").append(getMappedType(list.get(colTypeIndex).toString()))
                .append("? = null").append(NEW_LINE);
        return sb.toString();
    }

}
