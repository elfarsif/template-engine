- [x] Evaluating template “Hello, ${name}” with the value “Reader” for variable “name” results in the string “Hello,
  Reader”.

- [x] Evaluating template “${greeting}, ${name}” with values “Hi” and “Reader”, respectively, results in the string “Hi,
  Reader”.

- [x] Evaluating template “Hello, ${name}” with no value for variable “name” raises a MissingValueError.

- [x] Evaluating template “Hello, ${name}” with values “Hi” and “Reader” for variables “doesnotexist” and “name”,
  respectively, results in the string “Hello, Reader”.

- [x] Verify that a template of 100 words and 20 variables with values of approximately 15 characters each is evaluated
  in 200 milliseconds or less.


- [ ] Evaluate template “${one}, ${two}, ${three}” with values “1”, “${foo}”, and “3”, respectively, and verify that the
  template engine renders the result as “1, ${foo}, 3”.

