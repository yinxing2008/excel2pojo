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
        if (list.get(colNameIndex) == null || list.get(colTypeIndex) == null )
            return "";

        String colName = list.get(colNameIndex).toString().trim();
        String colType = list.get(colTypeIndex).toString().trim();
        String colDesc = "";
        if (list.get(colDescIndex) != null) {
            colDesc = list.get(colDescIndex).toString().trim();
        }

        if (!colDesc.isEmpty()) {
            sb.append("/**").append(NEW_LINE)
                    .append("* ").append(colDesc).append(NEW_LINE)
                    .append("*/").append(NEW_LINE);
        }
        if (!colName.isEmpty() && !colType.isEmpty()) {
            sb.append("var")
                    .append(" ").append(colName)
                    .append(": ").append(getMappedType(colType))
                    .append("? = null").append(NEW_LINE);
        }

        return sb.toString();
    }

}
