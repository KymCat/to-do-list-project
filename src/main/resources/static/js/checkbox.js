const checkboxes = document.querySelectorAll(".todo-checkbox");
const footer = document.querySelector(".todo-footer");
const counter = document.querySelector("#todo-selected-count");
const basket = document.querySelector("#checked-delete-btn");

// 체크박스 선택 이벤트
checkboxes.forEach(cb => {
    cb.addEventListener("change", () => {
        // 체크된 체크박스 갯수
        const cnt = document.querySelectorAll(".todo-checkbox:checked").length;

        if (cnt === 0)
            footer.style.display = "none";
        else {
            footer.style.display = "grid";
            counter.textContent = `${cnt}개 선택됨`;
        }
    });
});

// 휴지통 클릭 이벤트
basket.addEventListener("click", () => {
    // 체크된 체크박스
    const checked = document.querySelectorAll(".todo-checkbox:checked");

    // 체크된 체크박스 id, todayTask 가져오기
    const dtos = Array.from(checked)
        .map(cb => ({
            id : cb.getAttribute("data-bs-id"),
            todayTask : cb.getAttribute("data-bs-todo")
        }));

    const url = "/api/task";
    fetch(url, {
        method : "DELETE",
        headers : {
            "Content-Type" : "application/json"
        },
        body : JSON.stringify(dtos)
    })
    .then(response => {
        if (!response.ok)
            throw new Error("선택 항목 삭제 실패");
        return response.json();
    })
    .then(data => {
        footer.style.display = "none";

        // 제거된 항목 li에서 제외
        checked.forEach(cb => {
           const todoItem = cb.closest('li');
           if (todoItem)
               todoItem.remove();
        });

        // 선택된 개수 표시 업데이트
        footer.style.display = "none";
    })
    .catch(err => {
        console.log(err);
        alert("To-Do 삭제에 실패했습니다.")
    });
});
