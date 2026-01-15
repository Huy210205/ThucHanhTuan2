# Bài Tập Thực Hành Tuần 2 - Kiểm Thử với JUnit

## 📋 Mô tả bài toán

Chương trình phân tích dữ liệu điểm số học sinh với các chức năng:
- Đếm số học sinh đạt loại Giỏi (điểm >= 8.0)
- Tính điểm trung bình của các điểm hợp lệ (từ 0 đến 10)

### Yêu cầu kỹ thuật
- **Validate dữ liệu**: Bỏ qua các điểm < 0 hoặc > 10
- **Xử lý danh sách rỗng**: Trả về giá trị mặc định (0)
- **Kiểm thử đơn vị**: Sử dụng JUnit 5 để kiểm thử toàn diện

## 📁 Cấu trúc thư mục

```
unit-test/
├── src/
│   └── StudentAnalyzer.java      # Mã nguồn chính
└── test/
    └── StudentAnalyzerTest.java  # Kiểm thử đơn vị
```

## 🚀 Hướng dẫn chạy chương trình

### Yêu cầu hệ thống
- Java Development Kit (JDK) 8 trở lên
- Maven (hoặc sử dụng Maven wrapper đã có sẵn)

### Cách chạy test với Maven

#### Bước 1: Di chuyển vào thư mục project
```bash
cd unit-test
```

#### Bước 2: Chạy test
```bash
mvn test
```

#### Các lệnh Maven hữu ích khác:

**Xem kết quả chi tiết:**
```bash
mvn test -X
```

**Clean và chạy lại test:**
```bash
mvn clean test
```

**Compile code (không chạy test):**
```bash
mvn compile
```

**Xem cấu trúc dependencies:**
```bash
mvn dependency:tree
```

## ✅ Các test cases được implement

### Test cho `countExcellentStudents()`

| Test Case | Mô tả | Dữ liệu đầu vào | Kết quả mong đợi |
|-----------|-------|-----------------|------------------|
| Mixed Valid/Invalid | Danh sách có điểm hợp lệ và không hợp lệ | [9.0, 8.5, 7.0, 11.0, -1.0] | 2 |
| All Valid | Toàn bộ điểm hợp lệ | [9.5, 8.0, 7.5, 8.8, 6.0] | 3 |
| Empty List | Danh sách trống | [] | 0 |
| Null List | Danh sách null | null | 0 |
| Boundary Values | Điểm 0 và 10 | [0.0, 10.0, 8.0] | 2 |
| Negative Scores | Có điểm âm | [-5.0, 9.0, -2.0, 8.5] | 2 |
| Above Ten | Có điểm > 10 | [11.0, 9.0, 15.0, 8.5] | 2 |
| No Excellent | Không có học sinh giỏi | [5.0, 6.5, 7.0, 7.9] | 0 |
| All Excellent | Tất cả đều giỏi | [8.0, 8.5, 9.0, 9.5, 10.0] | 5 |
| Exactly 8.0 | Điểm đúng 8.0 | [7.9, 8.0, 8.1] | 2 |

### Test cho `calculateValidAverage()`

| Test Case | Mô tả | Dữ liệu đầu vào | Kết quả mong đợi |
|-----------|-------|-----------------|------------------|
| Mixed Valid/Invalid | Có điểm hợp lệ và không hợp lệ | [9.0, 8.5, 7.0, 11.0, -1.0] | 8.17 |
| All Valid | Toàn bộ hợp lệ | [8.0, 9.0, 7.0, 6.0] | 7.5 |
| Empty List | Danh sách trống | [] | 0.0 |
| Null List | Danh sách null | null | 0.0 |
| Only Zero | Chỉ có điểm 0 | [0.0, 0.0] | 0.0 |
| Only Ten | Chỉ có điểm 10 | [10.0, 10.0, 10.0] | 10.0 |
| All Invalid | Tất cả không hợp lệ | [-5.0, 11.0, -2.0, 15.0] | 0.0 |
| Negative and Above | Có điểm âm và > 10 | [-3.0, 8.0, 12.0, 6.0, -1.0] | 7.0 |
| Single Valid | Một điểm hợp lệ | [-5.0, 8.5, 15.0] | 8.5 |
| Boundary Values | Điểm biên 0 và 10 | [0.0, 10.0] | 5.0 |

## 📝 Issues trên GitHub

Bài tập này được quản lý thông qua các issues sau:

1. **Issue #1**: Viết hàm `countExcellentStudents()` - Xử lý kiểm tra điểm hợp lệ và đếm học sinh giỏi
2. **Issue #2**: Viết hàm `calculateValidAverage()` - Tính trung bình các điểm hợp lệ
3. **Issue #3**: Viết test cho 2 hàm trên - Sử dụng JUnit để kiểm thử đầy đủ
4. **Issue #4**: Viết tài liệu README.md - Mô tả bài toán, cách chạy chương trình và test

## 💡 Commit Messages

Các commit liên kết với issues:
```
feat: implement countExcellentStudents() #1
feat: implement calculateValidAverage() #2
test: add unit tests for both methods #3
docs: update README with instructions #4
```

## 👨‍💻 Tác giả

Sinh viên thực hiện bài tập thực hành Tuần 2 - Kiểm thử đơn vị với JUnit

## 📚 Tài liệu tham khảo

- [JUnit 5 User Guide](https://junit.org/junit5/docs/current/user-guide/)
- [JUnit 5 Assertions](https://junit.org/junit5/docs/current/api/org.junit.jupiter.api/org/junit/jupiter/api/Assertions.html)