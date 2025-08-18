const patchBtn = document.querySelector("#patch-btn");
patchBtn.addEventListener("click", () => {
    const update = {
        id : document.querySelector("#edit-id").value,
        todayTask : document.querySelector("#edit-todo").value
    };

    const url = `/api/task/${update.id}`;
    fetch(url, {
        method : "PATCH",
        headers : {
            "Content-Type" : "application/json"
        },
        body : JSON.stringify(update)
    }).then(response => {
        if(!response.ok)
            throw new Error("수정 실패");
        // .then(data) 로 넘김
        return response.json();
    })
    .then(data => {
        // 화면 DOM 업데이트

        // 수정 버튼을 누른 항목 찾기
        const todoItem = document.querySelector(`#edit-btn[data-bs-id = "${data.id}"]`)
            .closest(".todo-item");

        // 텍스트 수정
        if (todoItem) {
            const todoTitle = todoItem.querySelector(".todo-title");
            todoTitle.textContent = data.todayTask;
        }

        // 모달 닫기
        const modalElement = document.querySelector("#edit-modal");
        modalElement.setAttribute("inert", ""); // inert 속성 추가

        const modal = bootstrap.Modal.getInstance(modalElement); // 모달 객체 가져오기
        document.querySelector("#edit-btn").focus(); // 포커스 변경
        modal.hide();
    })
    .catch(err => {
        console.log(err);
        alert("To-Do 수정에 실패했습니다.");
    });
});