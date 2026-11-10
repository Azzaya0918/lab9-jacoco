# Лаборатори №9: Код хамралт — JaCoCo-гоор тестээ хөтлөх

F.CSA313 — Программ хангамжийн чанарын баталгаа ба тест (2026)

- Azzaya Azzaya
- B242270803 B242270803


## Хэсэг B: CFG ба branch 100%

![scholarship() CFG](cfg.png)

[cfg.png-д юу зурснаа 1-2 өгүүлбэрээр бич. Жишээ нь: зангилаа нь юуг төлөөлдөг, ирмэг дээр юу бичигдсэн, `&&` нөхцөл яагаад хоёр зангилаа болсон.]

Branch хамралтыг 100% хүргэхэд нийт **22** тест шаардагдсан (`results/mvn-verify-B.txt`-д `Tests run: 22`). Хэсэг A-д 5 тест байсан тул 17 тест нэмсэн. `results/jacoco-B.csv`-д `BRANCH_MISSED = 0`, `LINE_MISSED = 0` (Branch 41/41, Line 25/25).

Нэмсэн тестүүдийн гол санаа:

- `scholarship()`-ийн эхний `if (gpa < 0 || gpa > 4 || credits < 0)`-ийн нөхцөл бүрт тусдаа `assertThrows` тест бичсэн (`scholarshipNegativeGpaThrows`, `scholarshipGpaAboveFourThrows`, `scholarshipNegativeCreditsThrows`), учир нь JaCoCo `||` нөхцөл бүрийг тусдаа салаа гэж тоолдог.
- `&&` нөхцөлүүдийн кредит дутуу талыг `scholarshipHighGpaLowCreditsFallsTo50`, `scholarshipMidGpaLowCreditsFallsTo50` тестүүд хамарсан.
- `gpa()`-ийн `switch`-ийн `default` (F дүн) салааг `gpaAllGradeLetters` (A, B, C, D, F бүгд орсон массив) хамарсан.
- `letterGrade()`-ийн C, D, F болон хоёр хилийн алдааг тусдаа тестээр хамарсан.
