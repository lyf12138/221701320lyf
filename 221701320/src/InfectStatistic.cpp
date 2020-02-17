#include <iostream>
#include <vector>
#include <string>
#include <dirent.h>
#include <vector>
#include <string>
#include <fstream>
#include <iostream>

using namespace std;

int readfiledir()
{
    struct dirent *ptr;
    DIR *dir;
    string PATH = "D:/log";
    dir=opendir(PATH.c_str());
    vector<string> files;
    cout << "文件列表: "<< endl;
    while((ptr=readdir(dir))!=NULL)
    {
        //跳过'.'和'..'两个目录
        if(ptr->d_name[0] == '.')
            continue;
        //cout << ptr->d_name << endl;
        files.push_back(ptr->d_name);        
    }
    //写入TXT文件
    ofstream outfile;
    outfile.open("C:/1.txt", ofstream::app);  //myfile.bat是存放数据的文件名

    for (int i = 0; i < files.size(); ++i)
    {
        if(outfile.is_open())
        {
            outfile<<files[i] <<endl;    //message是程序中处理的数据
        }
        else
        {
            cout<<"不能打开文件!"<<endl;
        }

        cout << files[i] << endl;
    }
    outfile.close();
    closedir(dir);
    return 0;
}
int main()
{
	readfiledir();
 } 
