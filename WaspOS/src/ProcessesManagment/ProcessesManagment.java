package ProcessesManagment;
import java.lang.Object;
import java.util.LinkedList;
import java.util.List;

public class ProcessesManagment extends Proces {

	// TO JEST KLASA Z METODAMI DLA WAS RESZTY NIE RUSZAC
	
	//***ZMIENNE*****************************************************************************************
	
	public List<Proces> processesList;
	
	//---pomocnicze--------------------------------------------------------------------------------------
	
	private ID_Overseer idoverseer;
	
	private ProcessStateOverseer stateOverseer;
	
	private List<Integer> finishedProcessList;
	
	private int processNumber;
	
	//***METODY******************************************************************************************
	
	//---Konstruktor-------------------------------------------------------------------------------------
	
	public ProcessesManagment(){
		
		processesList = new LinkedList<Proces>();
		idoverseer = new ID_Overseer();
		stateOverseer = new ProcessStateOverseer();
		finishedProcessList = new LinkedList<Integer>();
		processNumber = 1;
	}
	
	//===Dodaj/Usun Procesy===============================================================================
	
	//---

	public void NewProcess_XC(String Name){
		
		Proces process = new Proces();
		process.CreateProcess(idoverseer.PickID(),Name, processNumber);
	
		processesList.add(process);
		processNumber++;
	}
	
	public void NewProcess_forUser(String ProgramPath_Original, String Name) {
		
		Proces process = new Proces();
		process.CreateProcess(idoverseer.PickID(),ProgramPath_Original, Name, processNumber);
	
		processesList.add(process);
		processNumber++;
	}
	
	//---
	
	private void  DeleteProcess() {
		
		for (int i = 0; i < finishedProcessList.size(); i++) {
			
			int index = FindProcessWithID(finishedProcessList.get(i));
			idoverseer.ClearID(processesList.get(index).GetID());
			processesList.remove(index);
		}
		
		finishedProcessList.clear();
	}
	
	public void DeleteProcessWithID(int ID) {
		
		int index = FindProcessWithID(ID);
		idoverseer.ClearID(ID);
		processesList.remove(index);
	}
	
	public void DeleteProcessWithName_XD(String name) {
		
		int index = FindProcessWithName(name);
		idoverseer.ClearID(processesList.get(index).GetID());
		processesList.remove(index);
	}
	
	//---sprawdz stany -> poszukiwanie procesow do usunieica---------------------------------------------
	
	public void CheckStates() {
		
		for (int i = 0; i < processesList.size(); i++) {
			
			if(processesList.get(i).pcb.ProcessState == stateOverseer.finished) {
				
				finishedProcessList.add(processesList.get(i).pcb.ProcessID);
			}
		}
		
		DeleteProcess();
	}
	
	//===Szukanie procesow===============================================================================
	
	//---
	
	public int FindProcessWithID(int ID) {
		
		Proces proces_kopia;
		
		for(int i = 0; i < processesList.size(); i++) {
			
			proces_kopia = processesList.get(i);
			
			if(proces_kopia.GetID() == ID) {
				
				return i;
			}	
		}
		
		return -1;
	}
	
	//---
	
	public int FindProcessWithName(String name) {
		
		Proces proces_kopia;
		
		for(int i = 0; i < processesList.size(); i++) {
			
			proces_kopia = processesList.get(i);
			
			if(proces_kopia.GetName()== name) {
				
				return i;
			}	
		}
		
		return -1;
	}
	
	//===Get/Set===========================================================================================
	
	//---
	
	public int GetIDwithName(String name) {
		
		int index = FindProcessWithName(name);
		return processesList.get(index).GetID();
	}
	
	//---
	
	public String GetNameWithID(int ID) {
		
		int index = FindProcessWithID(ID);
		return processesList.get(index).GetName();
	}
	
	//---
	
	public int GetWhenCameToListWithID(int ID) {
			
		int index = FindProcessWithID(ID);
		return processesList.get(index).GetWhenCameToList();
	}
		
	public void SetWhenCameToListWithID(int ID, int whenCametoList) {
			
		int index = FindProcessWithID(ID);
		processesList.get(index).SettWhenCameToList(whenCametoList);
	}
	
	//---
	
	public int GetStateWithID(int ID) {
			
		int index = FindProcessWithID(ID);
		return processesList.get(index).GetState();
	}
		
	public void SetState(int ID, int State) {
			
		int index = FindProcessWithID(ID);
		processesList.get(index).SetState(State);
	}
	
	//---
	
	public int GetBasePriorityWithID(int ID) {
			
		int index = FindProcessWithID(ID);
		return processesList.get(index).GetBasePriority();
	}
	
	//---
	
	public int GetCurrentPrirityWithID(int ID) {
			
		int index = FindProcessWithID(ID);
		return processesList.get(index).GetCurrentPriority();
	}
		
	public void SetCurrentPririty(int ID, int Priority) {
			
		int index = FindProcessWithID(ID);
		processesList.get(index).SetCurrentPriority(Priority);
	}
	
	//---
	
	public int GetHowLongWaitingWithID(int ID) {
			
		int index = FindProcessWithID(ID);
		return processesList.get(index).howLongWaiting;
	}
		
	public void SetHowLongWaitingWithID(int ID, int howLong) {
			
		int index = FindProcessWithID(ID);
		processesList.get(index).SetHowLongWaiting(howLong);
	}
	
	//---
	
	public boolean GetBlockedWithID(int ID) {
		
		int index = FindProcessWithID(ID);
		return processesList.get(index).GetBlocked();
	}
	
	public void SetBlocked(int ID, boolean blockedState) {
		
		int index = FindProcessWithID(ID);
		processesList.get(index).SetBlocked(blockedState);
	}
	
	//---
	
	public PCB GetPCBWithID(int ID) {
		
		int index = FindProcessWithID(ID);
		return processesList.get(index).pcb;
	}
	
	//===Shell=============================================================================================
	
	public void ReadProcessListInformations() {
		
		System.out.println("------------------------------");
		System.out.println("Lista Procesow:");
		
		for(int i = 0; i < processesList.size(); i++) {
			
			System.out.println( i + ". " + processesList.get(i).GetID() + ", " + processesList.get(i).GetName());
		}
	}

	public void ReadProcessInformations(int ID) {
		
		int index = FindProcessWithID(ID);
		processesList.get(index).ReadInformations();
	}
}
