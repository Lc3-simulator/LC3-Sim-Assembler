function assembleCode() {
    const assemblyCode = document.getElementById("assemblyCode").value;
    fetch('/api/assemble', {
        method: 'POST',
        headers: {
            'Content-Type': 'text/plain'
        },
        body: assemblyCode
    })
        .then(response => response.json())
        .then(data => {
            alert('Assembly Successful');
            updateMemoryAndRegisters();
        })
        .catch(error => {
            console.error('Error:', error);
        });
}

function executeInstruction() {
    fetch('/api/execute', { method: 'POST' })
        .then(response => response.json())
        .then(data => {
            alert('Instruction Executed');
            updateMemoryAndRegisters();
        })
        .catch(error => {
            console.error('Error:', error);
        });
}

function updateMemoryAndRegisters() {
    fetch('/api/memory')
        .then(response => response.json())
        .then(memory => {
            document.getElementById('memoryDisplay').textContent = JSON.stringify(memory, null, 2);
        });

    fetch('/api/registers')
        .then(response => response.json())
        .then(registers => {
            document.getElementById('registerDisplay').textContent = JSON.stringify(registers, null, 2);
        });
}
