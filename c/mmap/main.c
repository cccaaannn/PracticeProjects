#include <stdio.h>
#include <stdlib.h>
#include <sys/mman.h>
#include <unistd.h>

void* allocate_memory(size_t size);
int unallocate_memory(void* mem_start, size_t size);

int main() {
    size_t mem_size = sizeof(int) * 5;

    void* mem_start = allocate_memory(mem_size);

    int* arr = (int*)mem_start;
    for (int i = 0; i < 5; i++) {
        arr[i] = i;
    }

    for (int i = 0; i < 5; i++) {
        printf("%d\n", arr[i]);
    }

    unallocate_memory(mem_start, mem_size);

    return 0;
}

void* allocate_memory(size_t size) {
    printf("Allocating %zu bytes of memory\n", size);

    void* mem_start;

    // Allocate memory using mmap
    size_t READ_WRITE = PROT_READ | PROT_WRITE;
    size_t PRIVATE_ANONYMOUS = MAP_PRIVATE | MAP_ANONYMOUS;

    mem_start = mmap(
        NULL,               // Kernel chooses the address
        size,               // Size of memory to allocate
        READ_WRITE,         // Memory is readable and writable
        PRIVATE_ANONYMOUS,  // Private, anonymous mapping
        -1,                 // File descriptor
        0                   // Offset
    );
    if (mem_start == MAP_FAILED) {
        perror("mmap");
        exit(EXIT_FAILURE);
    }

    return mem_start;
}

int unallocate_memory(void* mem_start, size_t size) {
    printf("Unallocating %zu bytes of memory\n", size);

    if (munmap(mem_start, size) == -1) {
        perror("munmap");
        return -1;
    }
    return 0;
}
