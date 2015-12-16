#include "gtest/gtest.h"
#include "gmock/gmock.h"
#include "string"

#include "console.h"

class ConsoleMock : public Console {
 public:
  MOCK_METHOD1(write, void(std::string message));
};

TEST(mock, shouldExpectCall) {
    ConsoleMock console;
    EXPECT_CALL(console, write("the message"));

    console.write("the message");
}
