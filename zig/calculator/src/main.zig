const std = @import("std");
const print = std.debug.print;

fn read_int(comptime number_type: type) !number_type {
    const stdin = std.io.getStdIn().reader();

    var buffer: [8]u8 = undefined;

    if (try stdin.readUntilDelimiterOrEof(buffer[0..], '\n')) |value| {
        const line = std.mem.trimRight(u8, value[0..value.len - 1], "\r");
        return try std.fmt.parseInt(number_type, line, 10);
    } else {
        return @as(number_type, 0);
    }
}

fn read_float(comptime number_type: type) !number_type {
    const stdin = std.io.getStdIn().reader();

    var buffer: [8]u8 = undefined;

    if (try stdin.readUntilDelimiterOrEof(buffer[0..], '\n')) |value| {
        const line = std.mem.trimRight(u8, value[0..value.len - 1], "\r");
        return try std.fmt.parseFloat(number_type, line);
    } else {
        return @as(number_type, 0);
    }
}

const valid_operations = [_]u8{ 0, 1, 2, 3, 4 };

pub fn main() !void {
    print("---------- ---------- Welcome to calculator ---------- ----------\n", .{});

     while (true) {
        print("---------- Please choose operation ----------\n0-exit\n1-sum\n2-subtract\n3-multiply\n4-divide\n: ", .{});
        
        const operation = read_int(u8) catch {
            print("Invalid operation\n", .{});
            continue;
        };

        if (!std.mem.containsAtLeast(u8, &valid_operations, 1, &[_]u8{ operation })) {
            print("Invalid operation\n", .{});
            continue;
        }

        if (operation == 0) {
            break;
        }

        print("Enter num1: ", .{});
        const num1 = read_float(f32) catch {
            print("Invalid number\n", .{});
            continue;
        };

        print("Enter num2: ", .{});
        const num2 = read_float(f32) catch {
            print("Invalid number\n", .{});
            continue;
        };

        const result = switch (operation) {
            1 => num1 + num2,
            2 => num1 - num2,
            3 => num1 * num2,
            4 => blk: {
                if (num2 == 0) {
                    print("Division by zero\n", .{});
                    continue;
                }
                break :blk num1 / num2;
            },
            else => 0
        };

        print("Result is: {d:.3}\n", .{result});

        print("---------- ---------- ---------- ---------- ----------\n", .{});
    }

}
