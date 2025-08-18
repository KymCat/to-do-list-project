const form = document.querySelector("#todo-form");
form.addEventListener("submit", (e) => {
    e.preventDefault(); // 기본 새로 고침 막기

    const task = {
        todayTask : document.querySelector("#today-task").value
    };

    const url = "/api/task";
    fetch(url, {
        method : 'POST',
        headers : {
            "Content-Type" : "application/json"
        },
        body :JSON.stringify(task)
    }).then(response => {
        const msg = (response.ok) ? "등록 완료!" : "등록 실패!";
        alert(msg);
        window.location.reload();
    });
});
