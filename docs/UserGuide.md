---
layout: page
title: User Guide
---
![Banner](images/AgentAssistBanner.png) 
## AgentAssist
**Transform Your Credit Card Sales with AgentAssist** — the definitive desktop tool for bank agents. Merging the swift efficiency of a Command Line Interface (CLI) with the intuitive accessibility of a Graphical User Interface (GUI), AgentAssist propels your credit card sales into the fast lane. Tailored for the agile bank agent, this application lets you manage contact databases, track sales progress, and execute transactions with unprecedented speed. Maximize your productivity, minimize your response time, and amplify your sales performance. With AgentAssist, you're not just keeping up with the competitive world of credit card sales — _you're setting the pace_.

---

## Table of Contents

1. [Quick Start](#quick-start)
2. [Using AgentAssist](#using-agentassist)
3. [Features Overview](#features-overview)
    - [Save Current Data](#save-current-data)
    - [Add New Customer](#add-new-customer)
    - [Remove Old Customer](#remove-old-customer)
    - [Edit Existing Customer](#edit-existing-customer)
    - [Find a Customer by Details](#find-a-customer-by-details)
    - [Help](#help)
    - [Exit](#exit)
4. [FAQ](#faq)
5. [Known Issues](#known-issues)
6. [Command Summary](#command-summary)

--------------------------------------------------------------------------------------------------------------------

## Quick start {#quick-start}

### 1. Install Java 

Make sure you have **Java 17 or above** installed on your computer. You may skip this step if you already have it installed.

Installing Java:

* Download Java [here](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html). Follow the instructions on that page to install Java.

### 2. Download the AgentAssist application

Go to this [link](https://github.com/AY2425S1-CS2103T-T14-4/tp/releases) and download the latest version of the `.jar` file.

### 3. Choose a Folder

Find or create a folder on your computer where you want to store the AgentAssist information. <br>
Move the `.jar` file you just downloaded into this folder.

### 4. Open a Command Terminal

Now, open a command terminal:

* On Windows, press the **Windows Key** and type **`Command Prompt`** in the search bar. Click on the **Command Prompt** application to open it.
* On macOS, press **Cmd + Space**, type **`Terminal`** into the search bar, and press **Enter**.
* On Linux, open your Terminal application.

### 5. Run the applicaton

Navigate your terminal to the folder where you saved the AgentAssist application:

* Type **`cd `** (with a space after it), then drag and drop the folder where you placed the `.jar` file into the terminal window. The command should look similar to this: `cd '/Users/name/AgentAssistFolder'`. Press Enter.<br>

Type the following command: **`java -jar agentassist.jar`** and press **Enter**.

* A window similar to the below image should appear in a few seconds. You will see a graphical user interface with sample contact information already added.<br>
  ![Ui](images/Ui.png)

---

## Using AgentAssist {#using-agentassist}

AgentAssist's command box is your portal to managing contacts efficiently. Here’s how you can use it to streamline your tasks:

* To get started, simply type a command into the command box and hit **Enter**.

Some initial commands to try:


- **Viewing Contacts**
  * `list`: This command displays all contacts currently in your database, making it easy to browse through entries.

- **Adding a New Contact**
  * `add n/Jane Doe p/87654321 e/jane@example.com a/123 Jane Road j/doctor i/120000`: Adds Jane Doe to your database with detailed contact info, occupation, and income.

- **Editing a Contact**
  * `edit 1 p/12345678`: Updates the phone number of the first contact in your list to `12345678`.
  * `edit 4 rn/Updated remarks here`: Replaces the remarks of the fourth contact with "Updated remarks here".

- **Removing a Contact**
  * `delete 3`: Removes the third contact from your list. Ensure you have the correct index to avoid deleting the wrong entry.

- **Searching for a Contact**
  * `filter n/Jane`: Finds all contacts named Jane in your database. It’s a powerful tool for quickly locating entries.

- **Getting Help**
  * `help`: Opens a help dialog that provides a summary of all available commands and their usage.


**Pro Tip:** Experiment with combining commands like `filter` followed by `edit` or `delete` to manage your contacts more effectively. For example, use `filter j/doctor` to display all doctors, then `edit 2 a/321 New Address` to update the address for the second listed doctor.

The GUI will dynamically update to show the results of your commands, making it easy to see the impact of your actions in real time.

Refer to the [Features](#features-overview) section for more detailed instructions on each command.

---

## Features Overview {#features-overview}

### Feature 1: Ability to Save Current Data {#save-current-data}

**Purpose:**  
This feature ensures that any details you add to the app are saved automatically. When you close and reopen the app, all your data will still be there.

**How it Works:**
- **Command Format and Example:** Not applicable, as this process is automatic.

#### Parameters
- **Flags and Parameters:** There are no parameters needed for this feature.

#### What to Expect
- **If Successful:** You can access all the data you've entered previously.
- **If There is an Error:** There's a chance that the data might not be saved due to an error, and you could lose information.

---

### Feature 2: Add New Customer {#add-new-customer}

**Purpose:**  
This feature allows you to enter and save detailed records for new customers. Each customer's record includes their name, contact number, email, occupation, and income. You can also enter the optional fields for credit card tier and remark here. Otherwise, new users are assigned a default value of "N.A".

**How to Use It:**
  - **Command Format:**
    ```
    add n/ <NAME> p/ <PHONE> e/ <EMAIL> a/ <ADDRESS> j/ <JOBNAME> i/ <INCOME> [t/ <TIER>] [rn/ <REMARK>]
    ```
  - **Examples:**
    - Add new customer, basic convention: 
    ```
    add n/ TAN LESHEW p/ 99007766 e/ mrtan@ntu.sg a/ com3 j/ doctor i/ 99999
    ```
    - Add new customer with tier and remark:
    ```
    add n/ TAN LESHEW p/ 99007766 e/ mrtan@ntu.sg a/ com3 j/ doctor i/ 99999 t/ gold rn/ got anger issue
    ```
    

#### Parameters {#add-command-parameters}

| Parameter | Expected Format                                  | Explanation                                                                                                       |
|-----------|--------------------------------------------------|-------------------------------------------------------------------------------------------------------------------|
| NAME      | Alphanumeric, case insensitive                   | Accepts all names without case sensitivity. Names will be displayed in block letters for clarity and consistency. |
| PHONE     | 8-digit number, starts with 8 or 9               | Ensures the contact number is valid in Singapore.                                                                 |
| EMAIL     | Must include "@" and domain, case insensitive    | Verifies that the email address is in a standard format.                                                          |
| ADDRESS   | Any text, case insensitive                       | Accepts all addresses without case sensitivity. Addresses can have numbers and symbol alike /.                    |
| JOB       | Any text, case insensitive                       | Accepts all job titles without case sensitivity.                                                                  |
| INCOME    | Non-negative integers                            | Only positive numbers or zero are valid for income fields.                                                        |
| TIER      | [optional] String (gold, silver, bronze, reject) | Defines the specific credit card tier to be assigned or updated.                                                  |
| REMARK    | [optional] Any string                            | Notes are case-insensitive and can include any textual information.                                               |

#### What to Expect
- **If Successful:** 
  - Message: "New person added: `<NAME>`; Phone: `<PHONE>`; Email: `<EMAIL>`; Address: `<ADDRESS>`; Job: `<JOB>`;  Income: `<INCOME>`; Tier: `<TIER>`; Remark: `<REMARK>`". It's noted that if "Tier" and "Remark" are not added, they will be defined as "N/A."
- **If There is an Error:**
  - Message: "Please verify that your input is in the correct format. Include the following details: n/ `<NAME>` p/ `<PHONE>` e/ `<EMAIL>` a/ `<ADDRESS>` j/ `<JOBNAME>` i/ `<INCOME>` [t/ `<TIER>`] [rn/ `<REMARK>`]."

**Handling Duplicates:**  
If a customer with the same name, email, job, and income is already saved, you'll get a message: "This customer is already saved as a contact."

---

### Feature 3: Remove Old Customer {#remove-old-customer}

**Purpose:**  
This feature allows you to remove records of customers who are no longer using your credit card services.

**How to Use It:**
- **Command Format:**
  ```
  delete <INDEX>
  ```
- **Example:**
  ```
  delete 69
  ```

#### Parameters

| Parameter | Expected Format               | Explanation                                                                                                                                 |
|-----------|-------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------|
| INDEX     | Integer (1 to the last INDEX) | The INDEX must be a valid integer within the registered range (either the original list or any filtered list after using `filter` command). |

#### What to Expect
- **If Successful:** 
  - Message: "Customer `<INDEX>` has been deleted."
- **If There is an Error:**
  - Invalid index error message: "No customer with `<INDEX>` exists. Please recheck the index."

**Handling Duplicates:**  
Since customer INDEX are unique identifiers:
- No two customers can have the same index due to the uniqueness constraint on customer index.
- Even if a customer record appears duplicated due to data file modifications, the system assigns a unique index upon loading the data, preventing actual duplicates in the database.

---

### Feature 4: Edit the existing customer {#edit-existing-customer}

**Purpose:**  
This feature allows users to update the details of an existing customer in the database. All customer information can be modified, including contact details, address, job information, and other relevant data. Additionally, users can either append to or replace existing remarks and adjust the customer's tier status.

**How to Use It:**
- **Command Format:**
  ```
  edit <INDEX> n/ <NAME> p/ <PHONE> e/ <EMAIL> a/ <ADDRESS> j/ <JOB> i/ <INCOME> [t/ <TIER>] [rn/ <NEW REMARK>] [ra/ 
  <REMARK TO BE APPENDED ONTO EXISTING ONE>]
  ```
**Note that `rn/` and `ra/` cannot be used at the same time.**
  - **Examples:**
    - Edit only 1 specific field:
    ```
    edit 69 a/ Ridge View Residential College
    ```
    ```
    edit 69 t/ gold
    ```
    - Edit multiple fields at the same time:
    ```
    edit 69 p/ 99887766 e/ mrtan_newemail@ntu.sg j/ unemployed i/ 0 t/ reject
    ```
    - Append new remark onto existing one:
    ```
    edit 69 ra/ just know his dad is mr moore
    ```
    - Replace all remark(s) with a new remark:
    ```
    edit 69 rn/ ran out of money
    ```

#### Parameters

| Parameter | Expected Format                                  | Explanation                                                                                                                                 |
|-----------|--------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------|
| INDEX     | Integer (1 to the last INDEX)                    | The index must be a valid integer within the registered range (either the original list or any filtered list after using `filter` command). |
| NAME      | Alphanumeric, capitalized                        | Names are in block letters for clarity and consistency.                                                                                     |
| PHONE     | 8-digit number, starts with 8 or 9               | Ensures the contact number is valid in Singapore.                                                                                           |
| EMAIL     | Must include "@" and domain, case insensitive    | Verifies that the email address is in a standard format.                                                                                    |
| ADDRESS   | Any text, case insensitive                       | Accepts all addresses without case sensitivity. Addresses can have numbers and symbol alike /.                                              |
| JOB       | Any text, case insensitive                       | Accepts all job titles without case sensitivity.                                                                                            |
| INCOME    | Non-negative integers                            | Only positive numbers or zero are valid for income fields.                                                                                  |
| TIER      | [optional] String (gold, silver, bronze, reject) | Defines the specific credit card tier to be assigned or updated.                                                                            |
| REMARK    | [optional] Any string                            | For both `rn/` and `ra/`, remarks are case-insensitive and can include any textual information.                                             |

#### What to Expect
- **If Successful:**
  - Message: "Customer `<INDEX>` has been updated successfully."
- **If There is an Error:**
  - Message: "Failed to update customer `<INDEX>`."

**Handling Duplicates:**
- No two customers can have the same index due to the uniqueness constraint on customer index.

---

### Feature 5: Find a Customer by Details {#find-a-customer-by-details}

**Purpose:**  
This feature allows users to search for customers by specific details such as name, address, email, phone number, job title, or remarks. 

**How to Use It:**  
To perform a search, use the `filter` command followed by one or more flags (indicating the fields to search) and the corresponding search terms.

Searches are **case-insensitive** and use [**substring-matching**](#substring-matching), **except for [Tier](#filtering-by-tier) and [Income](#filtering-by-income)**, which have their own specific matching criteria detailed below.

- **Command Format:** 
  ```
  filter <FLAG>/ <SEARCH TERM> [<ADDITIONAL FLAGS>/ <SEARCH TERM>]
  ```
- **Examples:** 
  - Filter customers by name: 
    ```
    filter n/ TAN LESHEW
    ```
  - Filter customers by job:
    ```
    filter j/ doctor
    ```
  - Filter customers by name, job and remark:
    ```
    filter n/ Gordon Moore j/ doctor r/ award winner
    ```

#### Parameters

| Parameter   | Expected Format                                                                                                                                                                                                                                                       | Explanation                                                                                             |
|-------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------|
| FLAG        | Refer to the list of supported flags detailed below.                                                                                                                                                                                                                  | Identifies the field to search. <br/><br/> e.g., `n/` for name, `j/` for job.                           |                                                                          |
| SEARCH TERM | Follows the syntax for [each field's expected input](#add-command-parameters). <br/><br/>**Income** requires a numeric value with a comparison operator (`=`, `>`, `<`), while **Tier** allows for partial (prefix) matching. Other fields follow substring matching. | The value to search for in the specified field. <br/><br/> e.g., `doctor` for job, `>5000` for income). |

#### Supported flags:
- `n/` for Name
- `p/` for Phone Number
- `e/` for Email
- `a/` for Address
- `j/` for Job
- `r/` for Remarks
- `t/` for Tier

#### Substring Matching:
- Substring matching is used for searches, meaning that the search term must match a part of the field in the same order as it appears in the customer record.
- For instance, if a customer’s name is `Gordon Moore`, the search term `Gordon`, `Moore`, or `Gordon Moore` will match, but `Moore Gordon` will not.

#### Filtering By Tier
- **Prefix Matching:** Tier searches use **prefix matching**, meaning the search term must match the beginning of the tier exactly. 
  - If a customer has a tier labeled `Gold`, a search for `t/ G` or `t/ Gold` will match, but `t/ ld` or `t/ Gold Premium` will not.

#### Filtering By Income
- **Comparison Operators:** Filtering by income allows numeric comparisons using operators `=`, `>`, or `<` to find customers whose income meets certain criteria.
- **Equal to (`=`):** Use `=` to find customers with a specific income.  
  - `i/ =5000` will match customers with an income of exactly 5000.
- **Greater than (`>`):** Use `>` to find customers with an income higher than the specified threshold. 
  - `i/ >5000` will match customers with incomes greater than 5000.
- **Less than (`<`):** Use `<` to find customers with an income lower than the specified threshold.
  - `i/ <5000` will match customers with incomes below 5000.

#### What to Expect
- **If Successful:**
  - Message: "`x` person listed!", where `x` is the number of matching results.
- **If Unsuccessful (No Matches Found):**
  - Message: "0 persons listed!"
- **If There is an Error:** 
  - No Valid Flags Used:
    - Message:
    
      "filter: Searches for all customers whose specified field contains the given substring (case-insensitive) and displays the results in a numbered list.
    
      Parameters: `<FLAG>/ <SEARCH TERM>`
      
      Flags: `n/` (name), `p/` (phone), `e/` (email), `a/` (address), `j/` (job), `r/` (remarks)
      
      Example: `filter n/ Alice p/ 91112222`

      This will find all customers whose names contain 'Alice' and has phone number '91112222'."

  - Search Term Fails to Meet Requirement (i.e. Phone Number longer than 8 digits):
    - The system will display usage hints specific to the first invalid search term.

---

### Feature 6: Help {#help}

**Purpose:**  
This feature provides users with quick access to the command summary and the user guide for the application, helping them understand how to use various features effectively.

**How to Use It:**
- **Command Format:**
  ```
  help
  ```
- **Example:**
  ```
  help
  ```

#### Parameters
- **Flag:** N/A
  - There are no parameters required for this command.

#### What to Expect
- **If Successful:**
  - No immediate message is displayed in the command interface.
  - Opens up a dialog box that provides command summary table with command format and basic example, together with the hyperlink to the user guide markdown file, allowing users to easily access detailed instructions and information.

**Handling Duplicates:**
- N/A as this command does not involve processing or displaying data that could involve duplicates.

---
### Feature 7: Exit {#exit}

**Purpose:**  
Allows users to exit the application through a simple command, eliminating the need to use the window's close button or external controls.

**How to Use It:**
- **Command Format:**
  ```
  exit
  ```
- **Example:**
  ```
  exit
  ```

#### Parameters
- **Flag:** N/A
  - No parameters are needed to execute this command.

#### What to Expect
- **If Successful:**
  - The message "Terminating program…" is displayed.
  - The program will then exit after a short delay, effectively closing the application.

**Handling Duplicates:**
- N/A as this command is unique and does not process data that could involve duplicates.

--------------------------------------------------------------------------------------------------------------------

## FAQ {#faq}

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous AddressBook home folder.<br>

**Q**: How do I change the remarks or credit card tier of an existing customer?<br>
**A**: Use the [`edit`](#feature-4-edit-the-existing-customer) command, and specify the corresponding `t/` and or `rn/` or `ra/` flag to change these two fields.<br>

**Q**: Why am I getting an error when trying to edit the remark of an existing customer?<br>
**A**: Besides making sure that the command syntax is correct, please note that the `rn/` and `ra/` flags cannot be used together, as `rn/` is used to provide a new remark that will override any existing remark. Whilst, `ra/` will append a given remark to any existing remark.

**Q**: What do the different tier colors represent in the UI?  
**A**: Each credit card tier is visually distinguished in the UI: Gold is marked with a gold banner, Silver with a silver banner, Bronze with a bronze banner, and Reject with a red banner. This makes it easy to see at a glance the tier of each customer.


--------------------------------------------------------------------------------------------------------------------

## Known issues {#known-issues}

1. **When using multiple screens**, if you move the application to a secondary screen, and later switch to using only the primary screen, the GUI will open off-screen. The remedy is to delete the `preferences.json` file created by the application before running the application again.
2. **If you minimize the Help Window** and then run the `help` command (or use the `Help` menu, or the keyboard shortcut `F1`) again, the original Help Window will remain minimized, and no new Help Window will appear. The remedy is to manually restore the minimized Help Window.

--------------------------------------------------------------------------------------------------------------------

## Command Summary {#command-summary}

| Action                         | Command Format                                                                                                                                                 | Example                                                                                                        |
|--------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------|
| **Save Data Automatically**    | *Automatic*                                                                                                                                                    | *No command required*                                                                                          |
| **Add New Customer**           | `add n/ <NAME> p/ <PHONE> e/ <EMAIL> a/ <ADDRESS> j/ <JOB> i/ <INCOME> [t/ <TIER>] [rn/ <REMARK>]`                                                             | `add n/ TAN LESHEW p/ 99007766 e/ mrtan@ntu.sg a/ com3 j/ doctor i/ 99999 t/ gold rn/ got anger issue`         |
| **Remove Old Customer**        | `delete <INDEX>`                                                                                                                                               | `delete 69`                                                                                                    |
| **Edit Existing Customer**     | `edit <INDEX> n/ <NAME> p/ <PHONE> e/ <EMAIL> a/ <ADDRESS> j/ <JOB> i/ <INCOME> [t/ <TIER>] [rn/ <NEW REMARK>] [ra/ <REMARK TO BE APPENDED ONTO EXISTING ONE]` | `edit 69 n/ TAN LESHEW p/ 77337733 e/ mrtan@ntu.sg a/ COM3 j/ doctor i/ 1000000000 ra/ Specialist in eye care` |
| **Find a Customer by Details** | `filter <FLAG>/ <FLAG FIELD>`                                                                                                                                  | `filter n/ TAN LESHEW`                                                                                         |
| **Help**                       | `help`                                                                                                                                                         | `help`                                                                                                         |
| **Exit**                       | `exit`                                                                                                                                                         | `exit`                                                                                                         |
