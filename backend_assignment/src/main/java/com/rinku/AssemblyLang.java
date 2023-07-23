package com.rinku;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssemblyLang {
    private final DemoRepo programRepository;

    @Autowired
    public AssemblyLang(DemoRepo programRepository) {
        this.programRepository = programRepository;
    }

    public void executeProgram(String[] instructions) {
        int[] registers = new int[8];
        int[] memory = new int[100];
for (String instruction : instructions) {
            String[] parts = instruction.trim().split("\\s*,\\s*");
            String opcode = parts[0].toUpperCase();

            try {
                if (opcode.equals("LOAD")) {
                    int registerIndex = Integer.parseInt(parts[1].substring(1));
                    int value = Integer.parseInt(parts[2]);
                    registers[registerIndex] = value;
                } else if (opcode.equals("ADD")) {
                    int destRegister = Integer.parseInt(parts[1].substring(1));
                    int srcRegister = Integer.parseInt(parts[2].substring(1));
                    registers[destRegister] += registers[srcRegister];
                } else if (opcode.equals("STORE")) {
                    int registerIndex = Integer.parseInt(parts[1].substring(1));
                    int memoryAddress = Integer.parseInt(parts[2]);
                    memory[memoryAddress] = registers[registerIndex];
                } else {
                    // Handle other instructions as needed
                }
            } catch (NumberFormatException | IndexOutOfBoundsException e) {
                // Handle any parsing errors
                e.printStackTrace();
                saveProgramStatus(String.join("\n", instructions), false);
                return;
            }
        }

        // Execution completed successfully, save program status with success = true
        saveProgramStatus(String.join("\n", instructions), true);
    }

    private void saveProgramStatus(String instructions, boolean success) {
        Demo program = new Demo();
        program.setInstructions(instructions);
        program.setSuccess(success);
        programRepository.save(program);
    }
}
