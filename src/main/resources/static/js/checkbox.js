const checkboxes = document.querySelectorAll(".todo-checkbox");
const footer = document.querySelector(".todo-footer");
const counter = document.querySelector("#todo-selected-count");

checkboxes.forEach(cb => {
    cb.addEventListener("change", () => {
        // 체크된 체크박스 갯수
        const cnt = document.querySelectorAll(".todo-checkbox:checked").length;

        if (cnt === 0)
            footer.style.display = "none";
        else {
            footer.style.display = "flex";
            counter.textContent = `${cnt}개 선택됨`;
        }
    });
});
