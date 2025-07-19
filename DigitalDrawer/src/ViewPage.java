import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

// 기록 조회 페이지 (테이블 형식으로 보여줌)
public class ViewPage extends JPanel {
    public ViewPage(MainFrame frame) {
        setLayout(new BorderLayout());

        // 테이블 헤더 정의
        String[] colNames = {"날짜", "카테고리", "내용", "파일 경로"};
        DefaultTableModel model = new DefaultTableModel(colNames, 0);
        JTable table = new JTable(model); // JTable 생성

        // SharedData에 저장된 기록 가져와서 테이블에 삽입
        for (Record<String> r : SharedData.manager.getAllRecords()) {
            model.addRow(new Object[]{
                    r.getDate(), r.getCategory(), r.getContent(), r.getFilePath()
            });
        }

        // 테이블을 스크롤 패널에 넣고 패널에 추가
        add(new JScrollPane(table), BorderLayout.CENTER);
    }
}
