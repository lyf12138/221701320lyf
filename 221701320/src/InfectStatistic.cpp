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
    cout << "�ļ��б�: "<< endl;
    while((ptr=readdir(dir))!=NULL)
    {
        //����'.'��'..'����Ŀ¼
        if(ptr->d_name[0] == '.')
            continue;
        //cout << ptr->d_name << endl;
        files.push_back(ptr->d_name);        
    }
    //д��TXT�ļ�
    ofstream outfile;
    outfile.open("C:/1.txt", ofstream::app);  //myfile.bat�Ǵ�����ݵ��ļ���

    for (int i = 0; i < files.size(); ++i)
    {
        if(outfile.is_open())
        {
            outfile<<files[i] <<endl;    //message�ǳ����д��������
        }
        else
        {
            cout<<"���ܴ��ļ�!"<<endl;
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
