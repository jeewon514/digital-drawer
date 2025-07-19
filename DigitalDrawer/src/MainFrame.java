import javax.swing.*;
import java.awt.*;

// 메인 프레임 클래스: JFrame을 상속하여 프로그램의 전체 틀을 구성
public class MainFrame extends JFrame {
    private CardLayout cardLayout;   // 페이지 전환을 위한 CardLayout
    private JPanel cardPanel;        // 여러 페이지가 들어가는 컨테이너 패널

    public MainFrame() {
        setTitle("디지털 서랍장");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // CardLayout 설정
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        // 각 페이지 등록
        cardPanel.add(new InputPage(this), "input");
        cardPanel.add(new ViewPage(this), "view");

        // CardLayout 패널을 프레임에 추가
        add(cardPanel);

        setVisible(true);
    }

    // 페이지 전환 함수
    public void showPage(String name) {
        cardLayout.show(cardPanel, name);
    }

    // main 진입점
    public static void main(String[] args) {
        new MainFrame();
    }
}

