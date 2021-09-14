(() => {
    const initConfirmButtons = () => {
        const confirmButtons = document.querySelectorAll('.btn-confirm');
        confirmButtons.forEach((confirmButton) => {
            confirmButton.addEventListener('click', (e) => {
                if (!confirm('This action is irreversible, do you want to continue?')) {
                    e.preventDefault();
                }
            });
        });
    };

    const initCleanButtons = () => {
        const cleanButtons = document.querySelectorAll('.btn-clean');
        cleanButtons.forEach((cleanButton) => {
            const targetId = cleanButton.dataset.target;
            if (targetId) {
                const targetForm = document.querySelector(targetId);
                if (targetForm) {
                    cleanButton.addEventListener('click', () => {
                        for (let element of targetForm.elements) {
                            if (element.classList.contains('cleanable')) {
                                element.value = "";
                            }
                        }
                    });
                }
            }
        });
    }

    window.addEventListener('load', () => {
        initConfirmButtons();
        initCleanButtons();
    });
})();