import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class BaseExcelListener extends AnalysisEventListener {
    private List<Object> data = new ArrayList<>();
    protected final String NEW_LINE = "\r\n";
    protected Map<String, String> typeMap = new HashMap<>();

    @Override
    public void invoke(Object object, AnalysisContext context) {
        data.add(object);
        if (data.size() >= 100) {
            processData();
            data = new ArrayList<>();
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        processData();
    }

    public void processData() {
        StringBuffer sb = new StringBuffer();
        for (Object o : data) {
            sb.append(processRow((List) o));
        }
        System.out.println(sb.toString());
        setSysClipboardText(sb.toString());
    }

    protected String getMappedType(String type) {
        type = type.trim();
        String result = type;
        if (typeMap.containsKey(type)) {
            result = typeMap.get(type);
        }
        return result;
    }

    protected abstract String processRow(List list);

    /**
     * 将字符串复制到剪切板。
     */
    public static void setSysClipboardText(String info) {
        Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
        Transferable tText = new StringSelection(info);
        clip.setContents(tText, null);
    }
}
