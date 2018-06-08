template<class T>
string ToString(const T& t) {
	ostringstream oss;
	oss << t;
	return oss.str();
}

class Solution {
public:
	static bool Compare(const string &left, const string &right) {
		string leftright = left + right;
		string rightleft = right + left;
		return leftright < rightleft;
	}

    string PrintMinNumber(vector<int> numbers) {
    	vector<string> strings;
    	string str = "";
    	string res = "";

        for (unsigned int i = 0; i < numbers.size(); ++i)
        {
        	str = ToString(numbers[i]);
        	strings.push_back(str);
        }

        sort(strings.begin(), strings.end(), Compare);

        for (unsigned int i = 0; i < strings.size(); ++i)
        {
        	res += strings[i];
        }

        return res;
    }
};