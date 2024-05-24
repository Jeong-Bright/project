document.addEventListener("DOMContentLoaded", () => {
    const uploadButton = document.getElementById("upload-btn");
    const deleteButton = document.getElementById("delete-btn");
    const fileInput = document.getElementById("file-input");
    const profilePic = document.getElementById("profile-pic");
    const passwordChangeButton = document.getElementById("password-change-btn");

    uploadButton.addEventListener("click", () => {
        fileInput.click();
    });

    fileInput.addEventListener("change", (event) => {
        const file = event.target.files[0];
        if (file) {
            const reader = new FileReader();
            reader.onload = (e) => {
                profilePic.src = e.target.result;
            };
            reader.readAsDataURL(file);
        }
    });

    deleteButton.addEventListener("click", () => {
        profilePic.src = "profile-placeholder.png";
        fileInput.value = "";
    });

    passwordChangeButton.addEventListener("click", () => {
        window.location.href = "password-change.html";
    });

});
