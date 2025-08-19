const deleteBtn = document.querySelectorAll("#delete-btn");
deleteBtn.forEach(btn=> {
    btn.addEventListener("click", (e) => {
        const target = e.target;
        const id = target.getAttribute("data-bs-id");

        const url = `/api/task/${id}`;
        fetch(url, {
           method : "DELETE",
        })

        .then(response => {
            if(!response.ok)
                throw new Error("삭제 실패");
            return response.json();
        })

        .then(data => {
            // 페이지 새로고침 없이 목록에서 제외
            const todoItem = target.closest(".todo-item");
            todoItem.remove();
            alert(`"${data.todayTask}" 가 삭제 완료 되었습니다.`);
        })

        .catch(err => {
            console.log(err);
            alert("To-Do 삭제에 실패했습니다.")
        });
    });
});