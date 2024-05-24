#include<iostream>
#include<string>
#include<vector>

using namespace std;

class PersonalInfo {
public:
    string name;
    string dateOfBirth;
    string bloodGroup;
};

class PhysicalInfo {
public:
    float height;
    float weight;
};

class InsuranceInfo {
public:
    string policyNumber;
    string contactAddress;
};

class PersonDetails : public PersonalInfo, public PhysicalInfo, public InsuranceInfo {
public:
    string telephoneNumber;
    string drivingLicenseNumber;
};

void displayMenu() {
    cout << "\n1. Build a master table" << endl;
    cout << "2. Display" << endl;
    cout << "3. Insert a new entry" << endl;
    cout << "4. Delete entry" << endl;
    cout << "5. Edit" << endl;
    cout << "6. Search for a record" << endl;
    cout << "7. Exit" << endl;
}

int main() {
    vector<PersonDetails> masterTable;

    int choice;
    int i;
    do {
        displayMenu();
        cout << "Enter your choice: ";
        cin >> choice;

        switch (choice) {
            case 1:
                {
                    PersonDetails person;
                    cout << "Enter Name: ";
                    cin >> person.name;
                    cout << "Enter Date of Birth: ";
                    cin >> person.dateOfBirth;
                    cout << "Enter Blood Group: ";
                    cin >> person.bloodGroup;
                    cout << "Enter Height: ";
                    cin >> person.height;
                    cout << "Enter Weight: ";
                    cin >> person.weight;
                    cout << "Enter Policy Number: ";
                    cin >> person.policyNumber;
                    cout << "Enter Contact Address: ";
                    cin >> person.contactAddress;
                    cout << "Enter Telephone Number: ";
                    cin >> person.telephoneNumber;
                    cout << "Enter Driving License Number: ";
                    cin >> person.drivingLicenseNumber;

                    masterTable.push_back(person);
                    cout << "Entry added successfully!" << endl;
                }
                break;

            case 2:
                if (masterTable.empty()) {
                    cout << "Master table is empty!" << endl;
                } else {
                    for (int i = 0; i < masterTable.size(); ++i) {
                        cout << "Name: " << masterTable[i].name << ", Date of Birth: " << masterTable[i].dateOfBirth
                             << ", Blood Group: " << masterTable[i].bloodGroup << ", Telephone Number: " << masterTable[i].telephoneNumber << endl;
                    }
                }
                break;

            case 3:
                {
                    PersonDetails person;
                    cout << "Enter Name: ";
                    cin >> person.name;
                    cout << "Enter Date of Birth: ";
                    cin >> person.dateOfBirth;
                    cout << "Enter Blood Group: ";
                    cin >> person.bloodGroup;
                    cout << "Enter Height: ";
                    cin >> person.height;
                    cout << "Enter Weight: ";
                    cin >> person.weight;
                    cout << "Enter Policy Number: ";
                    cin >> person.policyNumber;
                    cout << "Enter Contact Address: ";
                    cin >> person.contactAddress;
                    cout << "Enter Telephone Number: ";
                    cin >> person.telephoneNumber;
                    cout << "Enter Driving License Number: ";
                    cin >> person.drivingLicenseNumber;

                    masterTable.push_back(person);
                    cout << "Entry inserted successfully!" << endl;
                }
                break;

            case 4:
                {
                    int index;
                    cout << "Enter index to delete: ";
                    cin >> index;

                    if (index >= 0 && index < masterTable.size()) {
                        masterTable.erase(masterTable.begin() + index);
                        cout << "Entry deleted successfully!" << endl;
                    } else {
                        cout << "Invalid index. No entry deleted." << endl;
                    }
                }
                break;

           case 5:
                {
                    int index;
                    cout << "Enter index to edit: ";
                    cin >> index;

                    if (index >= 0 && index < masterTable.size()) {
                        PersonDetails& person = masterTable[index];

                        cout << "Choose a field to edit (1-9): ";
                        int editChoice;
                        cin >> editChoice;

                        switch (editChoice) {
                            case 1: cout << "Enter new Name: "; cin >> person.name; break;
                            case 2: cout << "Enter new Date of Birth: "; cin >> person.dateOfBirth; break;
                            case 3: cout << "Enter new Blood Group: "; cin >> person.bloodGroup; break;
                            case 4: cout << "Enter new Height: "; cin >> person.height; break;
                            case 5: cout << "Enter new Weight: "; cin >> person.weight; break;
                            case 6: cout << "Enter new Policy Number: "; cin >> person.policyNumber; break;
                            case 7: cout << "Enter new Contact Address: "; cin >> person.contactAddress; break;
                            case 8: cout << "Enter new Telephone Number: "; cin >> person.telephoneNumber; break;
                            case 9: cout << "Enter new Driving License Number: "; cin >> person.drivingLicenseNumber; break;
                            default: cout << "Invalid choice. No field edited." << endl;
                        }

                        cout << "Entry edited successfully!" << endl;
                    } else {
                        cout << "Invalid index. No entry edited." << endl;
                    }
                }
                break;



            case 6:
    {
        string searchName;
        cout << "Enter name to search: ";
        cin >> searchName;

        bool found = false;
        for (int i = 0; i < masterTable.size(); ++i) {
            const PersonDetails& person = masterTable[i];
            if (person.name == searchName) {
                cout << "Name: " << person.name << ", Date of Birth: " << person.dateOfBirth
                     << ", Blood Group: " << person.bloodGroup << ", Telephone Number: " << person.telephoneNumber << endl;
                found = true;
                break;
            }
        }

        if (!found) {
            cout << "No record found for the given name." << endl;
        }
    }
    break;

            case 7:
                cout << "Exiting program. Goodbye!" << endl;
                break;

            default:
                cout << "Invalid choice. Please enter a valid option." << endl;
        }

    } while (choice != 7);

    return 0;
}
