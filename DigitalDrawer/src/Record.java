// 기록 정보를 저장하는 제네릭 클래스
public class Record<T> {
    private String date;       // 기록 날짜
    private String category;   // 카테고리
    private T content;         // 내용 (제네릭 타입)
    private String filePath;   // 관련된 파일 경로

    public Record(String date, String category, T content, String filePath) {
        this.date = date;
        this.category = category;
        this.content = content;
        this.filePath = filePath;
    }

    // Getter 메서드들
    public String getDate() { return date; }
    public String getCategory() { return category; }
    public T getContent() { return content; }
    public String getFilePath() { return filePath; }
}

