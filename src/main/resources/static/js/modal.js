const modal = document.querySelector("#edit-modal");
modal.addEventListener("show.bs.modal", (e) => {
    // 모달이 열리면 inert 속성 제거
    modal.removeAttribute("inert");

    // 트리거 선택
    const trigger = e.relatedTarget;

    // 트리거 데이터 가져오기
    const id = trigger.getAttribute("data-bs-id");
    const todayTodo = trigger.getAttribute("data-bs-todo");

    document.querySelector("#edit-todo").value = todayTodo;
    document.querySelector("#edit-id").value = id;
});
