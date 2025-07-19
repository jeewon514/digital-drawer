import javax.swing.*;
import java.awt.*;

// 기록 입력 페이지 (사용자가 직접 입력)
public class InputPage extends JPanel {
    public InputPage(MainFrame frame) {
        setLayout(new BorderLayout());

        // 입력 필드 영역 구성
        JPanel form = new JPanel(new GridLayout(5, 2));
        JTextField dateField = new JTextField();         // 날짜 입력 필드
        JTextField categoryField = new JTextField();     // 카테고리 입력 필드
        JTextArea contentArea = new JTextArea();         // 내용 입력 필드
        JTextField filePathField = new JTextField();     // 파일 경로 입력 필드
        JButton addButton = new JButton("기록 추가");     // 기록 추가 버튼

        // 폼 구성
        form.add(new JLabel("날짜 (YYYY-MM-DD):"));
        form.add(dateField);
        form.add(new JLabel("카테고리:"));
        form.add(categoryField);
        form.add(new JLabel("내용:"));
        form.add(new JScrollPane(contentArea));
        form.add(new JLabel("파일 경로:"));
        form.add(filePathField);
        form.add(new JLabel(""));
        form.add(addButton);

        // 패널에 추가
        add(form, BorderLayout.CENTER);

        // 버튼 클릭 시 기록 추가
        addButton.addActionListener(e -> {
            String date = dateField.getText();
            String category = categoryField.getText();
            String content = contentArea.getText();
            String file = filePathField.getText();

            // 기록 생성 및 추가
            Record<String> r = new Record<>(date, category, content, file);
            SharedData.manager.addRecord(r);

            // 알림 표시
            JOptionPane.showMessageDialog(this, "기록이 추가되었습니다.");
        });
    }
}

