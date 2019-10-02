#include "Const.h"
#include <iostream>

struct TriangleInfo
{
	std::string line;
	int side;
};

bool IsCorrectNumber(TriangleInfo& triangleInfo)
{
	try
	{
		triangleInfo.side = std::stoi(triangleInfo.line);
	}
	catch (const std::invalid_argument&)
	{
		return false;
	}

	return true;
}

std::string CheckTriangle(const int sideA, const int sideB, const int sideC)
{
	if ((sideA + sideB > sideC) && (sideB + sideC > sideA) && (sideA + sideC > sideB))
	{
		if (sideA == sideB && sideA == sideC)
		{
			return EQUILATERAL_TRIANGLE;
		}

		if (sideA == sideB || sideA == sideC || sideB == sideC)
		{
			return ISOSCELES_TRIANGLE;
		}

		return REGULAR_TRIANGLE;
	}
	else
	{
		return NOT_TRIANGLE;
	}
}

int main(int argc, char* argv[])
{
	if (argc != 4)
	{
		std::cerr << ERROR_NOT_ENOUGH_ARGUMENTS << std::endl;
		return 1;
	}

	TriangleInfo sideTriangleA{ argv[1] };
	TriangleInfo sideTriangleB{ argv[2] };
	TriangleInfo sideTriangleC{ argv[3] };

	if (!IsCorrectNumber(sideTriangleA) || !IsCorrectNumber(sideTriangleB) || !IsCorrectNumber(sideTriangleC))
	{
		std::cout << UNKNOWN_ERROR << std::endl;
		return 1;
	}

	std::cout << CheckTriangle(sideTriangleA.side, sideTriangleB.side, sideTriangleC.side) << std::endl;

	return 0;
}