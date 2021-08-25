(() => {
    const initConfirmButtons = () => {
        const confirmButtons = document.querySelectorAll('.btn-confirm');
        confirmButtons.forEach((confirmButton) => {
            confirmButton.addEventListener('click', (e) => {
                if (!confirm('¿Desea continuar?')) {
                    e.preventDefault();
                }
            });
        });
    };

    window.addEventListener('load', () => {
        initConfirmButtons();
    });
})();