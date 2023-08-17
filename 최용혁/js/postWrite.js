
var addPicture = document.getElementById("C-addPicture");
var picture = document.getElementById("C-picture");
var imageCount = 1;

addPicture.addEventListener("click", function() {
    var fileInput = document.createElement("input");
    fileInput.type = "file";
    fileInput.accept = "image/*";
    fileInput.style.display = "none";

    fileInput.addEventListener("change", function(event) {
        var selectedFile = event.target.files[0];
        if (selectedFile) {
            var newImageContainer = document.createElement("span");
            newImageContainer.className = "image-container";

            var newImage = document.createElement("img");
            newImage.src = URL.createObjectURL(selectedFile);
            newImage.alt = "사진 " + imageCount;

            newImageContainer.appendChild(newImage);
            picture.appendChild(newImageContainer);

            imageCount++;
        }
    });

    fileInput.click();
});