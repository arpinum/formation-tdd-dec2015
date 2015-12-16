project(tdd-kit-cpp)

cmake_minimum_required(VERSION 2.6)

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++11")

list(APPEND CMAKE_MODULE_PATH "${CMAKE_CURRENT_LIST_DIR}/cmake")

find_package(GTest REQUIRED)
include_directories(${GTEST_INCLUDE_DIRS})

find_package(GMock REQUIRED)
include_directories(${GMOCK_INCLUDE_DIRS})

file(GLOB SOURCES sources/**/*.cpp)
file(GLOB HEADERS sources/**/*.h)

add_executable(runtests ${SOURCES} ${HEADERS})

target_link_libraries(runtests ${GTEST_LIBRARIES} ${GMOCK_BOTH_LIBRARIES} pthread)
