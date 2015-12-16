#include "gtest/gtest.h"
#include "gmock/gmock.h"
#include "string"

#include "date_service.h"

using namespace std;
using namespace testing;

class DateServiceMock : public DateService {
 public:
  MOCK_METHOD0(currentDate, string());
};

TEST(mock, shouldReturnValue) {
    DateServiceMock dateService;
    EXPECT_CALL(dateService, currentDate()).WillOnce(Return("the date is now"));

    string theDate = dateService.currentDate();

    ASSERT_EQ("the date is now", theDate);
}
