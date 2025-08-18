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
        const msg = (response.ok) ? "To-Do 수정 완료" : "To-Do 수정 실패";
        alert(msg);
        window.location.reload();
    });
});