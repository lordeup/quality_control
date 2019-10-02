#include <fstream>
#include <iostream>
#include <sstream>
#include <string>
#include <vector>

const std::string SPACE = " ";

std::string RunExternalProgram(const char* path)
{
	std::string str;
	char buffer[100];
	FILE* inputFile = _popen(path, "r");

	if (inputFile)
	{
		while (fgets(buffer, sizeof buffer, inputFile) != NULL)
		{
			str += buffer;
		}

		_pclose(inputFile);
	}

	return str;
}

int main(int argc, char* argv[])
{
	if (argc != 3)
	{
		std::cerr << "The number of arguments does not match the condition of the task\n"
					 "The input should look like this: TriangleTests.exe Triangle.exe <input file>\n";
		return 1;
	}

	std::ifstream fileInput(argv[2]);

	if (!fileInput.is_open())
	{
		std::cerr << "This file does not exist" << std::endl;
		return 1;
	}

	std::string line;

	std::ofstream fileOutput("expectedOutput.txt");

	while (std::getline(fileInput, line))
	{
		std::string sideA, sideB, sideC, str1, str2, expectedResult, result;

		std::istringstream iss(line);

		iss >> sideA >> sideB >> sideC >> str1 >> str2;

		expectedResult = str1 + SPACE + str2 + "\n";

		std::string triangleSideStr = SPACE + sideA + SPACE + sideB + SPACE + sideC;
		result = RunExternalProgram(std::string(argv[1] + triangleSideStr).c_str());

		fileOutput << (result == expectedResult ? "Success" : "Error") << std::endl;
	}

	return 0;
}