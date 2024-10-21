---
layout: page
title: User Guide
---
![Banner](images/AgentAssistBanner.png) 
# Welcome to the AgentAssist User Guide!

The **AgentAssist User Guide** is here to help you unlock the full potential of **AgentAssist** and take your credit card sales to the next level. his guide offers clear, step-by-step instructions and practical examples to help you get the most out of the application.

In this guide, you'll learn how to:
* **Set Up AgentAssist**
* **Navigate and Use Key Features** like contact management, filtering, and more.
* **Optimize Your Workflow** with shortcuts, data export/import, and automatic saving.

Let’s begin and get you up to speed with AgentAssist!

--------------------------------------------------------------------------------------------------------------------

# Table of Contents

1. [Introduction](#1-introduction)
2. [Important Prerequisites](#2-important-prerequisites)
3. [Getting Started](#3-getting-started)
   <details>
   <summary>Subsections</summary>

   3.1 [Installation](#31-installation)  
   3.2 [Graphical User Interface (GUI) Layout](#32-graphical-user-interface-gui-layout)

   </details>

4. [Understanding Commands in AgentAssist](#4-understanding-commands-in-agentassist)
   <details>
   <summary>Subsections</summary>

   4.1 [Command Structure Overview](#41-command-structure-overview)  
   4.2 [Commands](#42-commands)  
   4.3 [Flags](#43-flags)  
   4.4 [Arguments](#44-arguments)  
   4.5 [Using Commands](#45-using-commands)

   </details>

5. [Commands](#5-commands)
   <details>
   <summary>Subsections</summary>

   5.1 [How to Read Commands](#51-how-to-read-commands)  
   5.2 [Data Modification Commands](#52-data-modification-commands)  
   5.3 [Data Filtering Commands](#53-data-filtering-commands)  
   5.4 [General Commands](#54-general-commands)  
   5.5 [Saving Data](#55-saving-data)  
   5.6 [Modifying the Data File](#56-modifying-the-data-file)

   </details>
   
6. [FAQ](#6-faq)
7. [Known Issues](#7-known-issues)
8. [Command Summary](#8-command-summary)


# 1. Introduction
## 1.1 What is AgentAssist?

AgentAssist is the **definitive desktop tool for credit card sales agents**. Merging the swift efficiency of a Command Line Interface (CLI) with the intuitive accessibility of a Graphical User Interface (GUI), this application lets you manage contact databases, track sales progress, and execute transactions with unprecedented speed. 

**Overview of Key Features:**
* **Contact Management**: 
  * Manage your client details easily. Add, edit, and delete contacts to keep all your client information in one accessible place.
* **Keyboard-only Navigation**: 
  * Navigate through the application entirely via keyboard shortcuts, improving workflow efficiency.
* **Multi-Level Filtering**: 
  * Filter your data by multiple criteria to find exactly who you’re looking for.
* **Auto-Save**: 
  * Automatically saves your work as you go, ensuring data is updated without manual intervention.
* **Effortless Data Import & Export**: 
  * Import or export client and sales data in compatible formats for backups or use in other systems.

Maximize your productivity, minimize your response time, and amplify your sales performance. With AgentAssist, you're not just keeping up with the competitive world of credit card sales — _you're setting the pace_.

--------------------------------------------------------------------------------------------------------------------

# 2. Important Prerequisites

Before you start using AgentAssist, there are a few prerequisites to ensure you get the most out of the application:

### Familiarity with Keyboard Navigation
AgentAssist is designed to enhance speed and efficiency, with a strong focus on **keyboard-based navigation**. While the application includes a Graphical User Interface (GUI), its full potential is unlocked when you use **keyboard commands**. Therefore, it is important to:

- Be comfortable navigating applications using the keyboard.
- Familiarize yourself with basic `Command Line Interface (CLI)` commands if you haven't already. This will make it easier to use AgentAssist’s command system effectively.
- Know common keyboard shortcuts (e.g., `Enter`, `Arrow keys`, etc.).

### Basic Understanding of Data Fields
AgentAssist allows you to manage client data like names, phone numbers, emails, and job information. A basic understanding of these data fields will make it easier to add, edit, and filter client information.

🎉 **By meeting these prerequisites, you'll be ready to make the most of AgentAssist’s fast, keyboard-driven interface and powerful data management features.** 🎉

# 3. Getting Started
Welcome to AgentAssist. Here’s how to get up and running quickly and easily.

## 3.1 Installation 
### Step 1: Install Java 

Ensure you have **Java 17** installed on your computer. AgentAssist is optimized for **Java 17**, and using other versions may affect performance or functionality. If you already have Java 17 installed, you can skip this step.

To install Java 17:
* Visit the Java download page from [Oracle](https://www.oracle.com/java/technologies/downloads/#java17?er=221886). 
* Download the appropriate installer for your operating system (Windows, macOS, or Linux).
* Follow the installation instructions on the website to complete the setup.
* Once installed, verify the installation by [opening your terminal (or command prompt)](#how-to-open-terminal) and typing:  
    ```
    java -version
    ```
* If you see Java 17 in the output, you’re good to go!

### Step 2: Download the AgentAssist application

Download the latest version of the `.jar` file from the AgentAssist [repository](https://github.com/AY2425S1-CS2103T-T14-4/tp/releases).

[comment]: # (TODO: Add image of GitHub Releases page with annotations to show user the file to install.) 

### Step 3: Choose a Folder

Find or create a folder on your computer where you want to store the AgentAssist application and its data.  
Move the .jar file you downloaded into this folder.

### Step 4: Run the Application

1. **Open a command terminal**
   - On Windows, press `Windows Key + R`, type `cmd`, and press `Enter`.
   - On macOS, press `Command + Space`, type `Terminal`, and press `Enter`.
   - On Linux, open your **Terminal** application from the system menu.

2. **Navigate your terminal to the folder where you saved the AgentAssist application:**
   - To do this, use the `cd` command followed by the path to your folder.\
    >  ℹ️ **Tip:** Follow the guide below to navigate to your folder in the terminal:
    >
    > <details><summary><strong>Click here to learn how to navigate to your folder in terminal</strong></summary>
    >
    > - **Windows**: Use the command `cd <folder path>`.   
        For example, if **AgentAssist** is stored in the `Downloads` folder:
    >   ```bash
    >   cd C:\Users\<YourUsername>\Downloads
    >   ```
    >
    > - **macOS/Linux**: Use the command `cd <folder path>`.  
        For example, if **AgentAssist** is stored in the `Downloads` folder:
    >   ```bash
    >   cd /Users/<YourUsername>/Downloads
    >   ```
    >   
    > </details>
   
3. Run the application:
   - Type the following command: **`java -jar agentassist.jar`** and press **Enter**.
   - A window similar to the below image should appear in a few seconds. You will see a graphical user interface with sample contact information already added.<br><br>
   ![Ui](images/Ui.png)

4. 🎉 **Congratulations! AgentAssist is now up and running!** 🎉  
   You're all set to start using AgentAssist to manage your contacts, track your sales, and boost your productivity! 

## 3.2 Graphical User Interface (GUI) Layout


To learn more about how to use commands in AgentAssist, proceed to the next section.

--------------------------------------------------------------------------------------------------------------------

# 4. Understanding Commands in AgentAssist {#using-agentassist}

The true power of **AgentAssist** lies in efficiently using commands. Before diving into specific commands, let’s break down the basic structure of a command.

## 4.1 Command Structure Overview
Each command in AgentAssist consists of three key components: the **command**, **flag(s)**, and **argument(s)**.

Let's take a look at the structure in more detail:

| **Components**  | **Description**                                                                                                                                               | **Example**                    |
|:----------------|:--------------------------------------------------------------------------------------------------------------------------------------------------------------|:-------------------------------|
| **Command**     | The action you want AgentAssist to perform.                                                                                                                   | `add`                          |
| **Flag(s)**     | Modifiers that specify what kind of data is being handled. <br/><br/>Flag(s) are typically 1-2 letters followed by a backslash.                               | `n/`, `p/`, `r/`, `rn/`        |
| **Argument(s)** | The values or inputs the command uses, such as client data or specific details. <br><br> The user guide may represent it as a placeholder using `<ARGUMENT>`. | `John Doe`, `john@example.com` |

Here's an example that uses multiple flags and arguments:
```
add n/ John Doe e/ john@example.com
```
* **Command:** `add` instructs AgentAssist to add a new entry.
* **Flags:** `n/` and `e/` specify the information type (name and email).
* **Arguments:** `John Doe` and `john@example.com` are the actual values being input for the respective flags.


## 4.2 Commands
A command is the action that AgentAssist will perform, such as adding, deleting, or editing a contact. 

Here is a reference table that briefly summarizes available commands:

| **Command** | **Description**                                        |
|-------------|--------------------------------------------------------|
| `add`       | Adds a new client to the system.                       |
| `edit`      | Modifies details of an existing client.                |
| `delete`    | Removes a client from the system.                      |
| `list`      | Displays all clients currently stored in the system.   |
| `filter`    | Filters clients based on specified criteria            |
| `clear`     | Deletes all clients from the system.                   |
| `help`      | Displays a list of available commands and their usage. |
| `exit`      | Exits the AgentAssist application.                     |

Refer to the [Commands Section](#commands-section) for more comprehensive details of each command.

## 4.3 Flags

AgentAssist uses flags as a shorthand for different options in commands. Flags help you specify what kind of information you are providing, allowing you to write shorter and more efficient commands, improving your workflow.

Here’s a reference table of available flags and the type of data they correspond to: 

| **Flag** | **Type of Data** |
|----------|------------------|
| `i/`     | `index`          |
| `n/`     | `name`           |
| `p/`     | `phone`          |
| `e/`     | `email`          |
| `a/`     | `address`        |
| `j/`     | `job`            |
| `i/`     | `income`         |
| `t/`     | `tier`           |
| `r/`     | `remark`         |
| `ra/`    | `remark append`  |
| `rn/`    | `remark new`     |

> 💡 **Pro Tip:**
> 
> Flags are typically derived from the first letter of their corresponding data type (e.g., `n/` for `name`), making them easy to remember!

## 4.4 Arguments

Arguments are the values that follow each flag in a command. **Arguments cannot be empty**, and each must meet specific parsing and format requirements to ensure proper execution of the command.

Refer to the table below for more details.

| **Flag** | **Expected Argument** | **Description**                                | **Requirements**                                                                                | **Case Sensitivity**  |
|----------|-----------------------|------------------------------------------------|-------------------------------------------------------------------------------------------------|-----------------------|
| `n/`     | `<NAME>`              | The client's full name                         | Letters, numbers, and spaces only                                                               | ❌                     |
| `p/`     | `<PHONE>`             | The client's phone number                      | Valid Singapore phone number:<br/> • 8-digit number<br/> • Starts with 8 or 9                   | ❌                     |
| `e/`     | `<EMAIL>`             | The client's email address                     | Valid email format (`username@domain.com`)                                                      | ❌                     |
| `a/`     | `<ADDRESS>`           | The client's physical address                  | No specific restrictions                                                                        | ❌                     |
| `j/`     | `<JOBNAME>`           | The client's job title or profession           | No specific restrictions                                                                        | ❌                     |
| `i/`     | `<INCOME>`            | The client's annual income                     | Positive number or zero <br/> • Cannot include commas and decimal points<br/> • Must be numeric | ❌                     |
| `t/`     | `<TIER>`              | The client's assigned tier level               | Predefined tiers:<br/> • Gold, Silver, Bronze, Reject                                           | ✔️                    |
| `r/`     | `<REMARK>`            | General remarks about the client               | No specific restrictions                                                                        | ❌                     |
| `ra/`    | `<REMARK TO APPEND>`  | Append information to the existing remark      | No specific restrictions                                                                        | ❌                     |
| `rn/`    | `<NEW REMARK>`        | Replaces the existing remark with a new remark | No specific restrictions                                                                        | ❌                     |    

> 💡 **Pro Tip:**
> 
> Ensure every flag is followed by a valid argument!
>
> Providing a flag without an accompanying argument will result in an error and prevent the command from executing properly.

## 4.5 Using Commands
To get started, simply type a command into the command box and hit **Enter**.

Some initial commands to try:  
**Viewing All Clients**
* `list`: This command displays all clients currently in your database, making it easy to browse through entries.

**Adding a New Client**
* `add n/Jane Doe p/87654321 e/jane@example.com a/123 Jane Road j/doctor i/120000`: Adds Jane Doe to your database with detailed contact information, job title, and income.

**Editing a Client's Information**
* `edit 1 p/12345678`: Updates the phone number of the first client in your list to `12345678`.
* `edit 4 rn/Updated remarks here`: Replaces the remarks of the fourth client with "Updated remarks here".

**Removing a Client**
* `delete 3`: Removes the third client from your list. Ensure you have the correct index to avoid deleting the wrong client. 

**Searching for a Client**
* `filter n/Jane`: Finds all client named Jane in your database. It’s a powerful tool for quickly locating clients or filtering for a specific type of client.

**Getting Help**
* `help`: Opens a help dialog that provides a summary of all available commands and their usage. 

The GUI will dynamically update to show the results of your commands, making it easy to see the impact of your actions in real time.

Refer to the [Commands Section](#commands-section) for more comprehensive details of each command.

> 💡 **Pro Tip:**  
> Combine commands like `filter` followed by `edit` or `delete` to manage your contacts more effectively.  
> For example, use `filter j/doctor` to display all doctors, then `edit 2 a/321 New Address` to update the address for the second listed doctor.

--------------------------------------------------------------------------------------------------------------------

# 5. Commands

## 5.1 How to Read Commands

When working with commands in **AgentAssist**, it's important to understand **how the command format is structured**. Commands consist of specific components like **flags** and **arguments**, and some parts of the command can be **optional**.

If you're unfamiliar with how commands are structured, refer back to the [Command Structure Overview in Section 4.1](#command-structure-overview) for more details on how flags, arguments, and placeholders work together.

### Command Syntax

When reading commands, there are certain syntax conventions that help indicate how to use them:

- **`< >` (Angle Brackets):**  
  Text enclosed in angle brackets represents a **placeholder** for the actual value you need to provide. For example, `<NAME>` should be replaced by the client's actual name, such as "John Doe."

- **`[ ]` (Square Brackets):**  
  Components enclosed in square brackets are **optional**. You can choose to include them if necessary, but they are not required for the command to execute. For instance, `[t/ <TIER>]` means that the credit card tier is optional, and if omitted, a default value will be used.

### Example Command:
```
add n/ <NAME> p/ <PHONE> e/ <EMAIL> a/ <ADDRESS> j/ <JOBNAME> i/ <INCOME> [t/ <TIER>] [rn/ <REMARK>]
```
- **Mandatory Components**: Flags such as `n/`, `p/`, `e/`, `a/`, `j/`, and `i/` must be followed by valid arguments like the name, phone number, and job title.
- **Optional Components**: Flags like `t/` and `rn/` are enclosed in square brackets, indicating they are optional.

## 5.2 Data Modification Commands

### 5.2.1 Adding a new client {#add-command}

**Purpose:** Save detailed records of a new client. 

Each client's record includes their name, contact number, email, occupation, and income. You can also enter the optional fields for credit card tier and remark here. Otherwise, new users are assigned a default value of "N.A".

**Command Format:**
  ```
  add n/ <NAME> p/ <PHONE> e/ <EMAIL> a/ <ADDRESS> j/ <JOBNAME> i/ <INCOME> [t/ <TIER>] [rn/ <REMARK>]
  ```
* Mandatory Fields: `n/`, `p/`, `e/`, `a/`, `j/`, `i/`
* Optional Fields: `t/`, `rn/`

For detailed explanations of each flag and acceptable arguments, refer to Sections [4.3 Flags](#43-flags) and [4.4 Arguments](#44-arguments)

**Examples:**
- Add new customer (without optional fields):
  ```
  add n/ JOHN DOE p/ 99007766 e/ mrdoe@ntu.sg a/ com3 j/ doctor i/ 99999
  ```
- Add new customer with tier and remark:
  ```
  add n/ JOHN DOE p/ 99007766 e/ mrdoe@ntu.sg a/ com3 j/ doctor i/ 99999 t/ gold rn/ got anger issue
  ```

#### What to Expect
- **On Success:** 
  - Message: 
    ```
    New client added: Name: <NAME>, Phone: <PHONE>, Email: <EMAIL>, Address: <ADDRESS>, Job: <JOB>, Income: <INCOME>, Tier: <TIER>, Remark: <REMARK>.
    ```
  - If "Tier" and "Remark" are not provided, they will be set to "N.A." and displayed as such in the success message.

- **On Error**
  - Message: 
    ```
    Please verify that your input is in the correct format. Include the following details: n/ <NAME> p/ <PHONE> e/ <EMAIL> a/ <ADDRESS> j/ <JOBNAME> i/ <INCOME> [t/ <TIER>] [rn/ <REMARK>].
    ```

> **Note on Duplicates:**
>
> AgentAssist will prevent duplicate entries if a client with the **same name, email, job, and income** is already saved.  
> When this happens, you will see the following message:
>
> ```
> This customer is already saved as a contact.
> ```
>
> **The duplicate contact will not be saved** to prevent redundancy.
>
> If you need to update details for an existing contact, use the `edit` command instead.  
> For more information, see Section [5.2.2 Editing a client](#edit-command).




### 5.2.2 Edit an Existing Client's Information {#edit-command}

**Purpose:** Update the details of an existing client in the database. 

All client information, including contact details, address, job information, and other relevant data, can be modified. You can also append to or replace existing remarks and adjust the client's tier status.

**Command Format:**
```
edit <INDEX> n/ <NAME> p/ <PHONE> e/ <EMAIL> a/ <ADDRESS> j/ <JOB> i/ <INCOME> [t/ <TIER>] [rn/ <NEW REMARK>] [ra/ <REMARK TO BE APPENDED>]
```
- Mandatory Field: `<INDEX>`
- Optional Fields: `n/`, `p/`, `e/`, `a/`, `j/`, `i/`, `t/`, `rn/`, `ra/`
- **Note:** `rn/` (new remark) and `ra/` (append remark) cannot be used simultaneously in a single command.

For detailed explanations of each flag and acceptable arguments, refer to Sections [4.3 Flags](#43-flags) and [4.4 Arguments](#44-arguments)

**Examples:**
- Edit only 1 specific field:
    ```
    edit 12 a/ Ridge View Residential College
    ```
    ```
    edit 12 t/ gold
    ```

- Edit multiple fields at the same time:
    ```
    edit 12 p/ 99887766 e/ mrtan_newemail@ntu.sg j/ unemployed i/ 0 t/ reject
    ```
- Append new remark onto existing one:
    ```
    edit 12 ra/ Recently received Gordon E. Moore Award
    ```
- Replace all remark(s) with a new remark:
    ```
    edit 69 rn/ Do not call, angry about calls 
    ```

**What to Expect:**
- **On Success:**
  - Message:
    ```
    Customer <INDEX> has been updated successfully.
    ```
- **On Error:**
  - Message:
    ```
    Failed to update customer <INDEX>.
    ```
    
> 💡 **Pro Tip:**  
> No need to worry about duplicate indexes—AgentAssist guarantees that every customer has a unique index automatically.




### 5.2.3 Delete an Existing Client {#delete-command}

**Purpose:** Remove records of customers who are no longer using your credit card services.

**Command Format:**
```
delete <INDEX>
```
* Mandatory Field: `<INDEX>`
* Note: The provided `<INDEX>` must be **greater than 0 and less than the total number of customers in the list**.

For detailed explanations of each flag and acceptable arguments, refer to Sections [4.3 Flags](#43-flags) and [4.4 Arguments](#44-arguments)

**Examples:**
- Remove a customer with a specific index (e.g. at index 12):
    ```
    delete 12
    ```
  
**What to Expect:**
- **On Success:**
    - Message:
      ```
      Customer <INDEX> has been deleted.
      ```
- **On Error:**
    - Invalid index error message:
      ```
      No customer with <INDEX> exists. Please recheck the index.
      ```

> 💡 **Pro Tip:**  
> No need to worry about duplicate indexes—AgentAssist guarantees that every customer has a unique index automatically.




### 5.2.4 Delete All Existing Clients {#clear-command}

**Purpose:** Delete all clients from the database, effectively resetting the application’s contact list

**Command Format:**
```
clear
```

**What to Expect:**
- **On Success:**
  - Message:
    ```
    Address book has been cleared!
    ```
    The application will remove all client data from the list, effectively resetting the client database.
- **On Error:**
  - This command does not typically produce errors but will have no effect if there are no clients in the database to clear.

> ⛔ **Danger:**  
> The `clear` command is **irreversible** and does not provide a confirmation message before clearing all records. Once executed, all client data is **permanently deleted**.
>
> It is highly recommended to **avoid using this command** unless absolutely necessary.

 
 
 
## 5.3 Data Filtering Commands

### 5.3.1 List All Clients {#list-command}

**Purpose:** View a list of all clients saved in AgentAssist.

**Command Format:**
```
list
```
* No parameters are required for this command. Any parameter added will be ignored.




### 5.2.3 Filter Clients by Details / Find a Client {#filter-command}

**Purpose:** Search for clients by specific details such as name, address, email, phone number, job title, income, or remarks. 

**Command Format:**
```
filter n/ <NAME> p/ <PHONE> e/ <EMAIL> a/ <ADDRESS> j/ <JOB> r/ <REMARKS> t/ <TIER> i/ <INCOME>
```
- **Mandatory Field**: One or more flags with corresponding search terms.
- **Special Syntax for Income (i/)**:
  - When filtering by income, use comparison operators `=`, `>`, or `<` to specify criteria.
  - Example: `i/ >5000` will filter customers with an income greater than 5000.
  - See [Filtering By Income](#filtering-by-income) for more information.

For detailed explanations of each flag and acceptable arguments, refer to Sections [4.3 Flags](#43-flags) and [4.4 Arguments](#44-arguments)

**Examples:**
- Filter customers by name:
  ```
  filter n/ John Doe
  ```
- Filter customers by job:
  ```
  filter j/ doctor
  ```
- Filter customers by name, job and remark:
  ```
  filter n/ Gordon Moore j/ doctor r/ award winner
  ```
**Matching Criteria & Filter Behavior:**

- **Substring Matching: (For most fields)**  
  Searches for most fields use **substring matching**, meaning the search term must match part of the field in the same order as it appears in the customer record.
  - **Example:**  
  If a customer’s name is `Gordon Moore`, the search term `Gordon`, `Moore`, or `Gordon Moore` will match, but `Moore Gordon` will not.
 
- **Filtering by Tier (Prefix Matching):**  
  Tier searches use **prefix matching**, meaning the search term must match the beginning of the tier exactly.
  - **Example:**  
  If a customer has a tier labeled `Gold`, a search for `t/ G` or `t/ Gold` will match, but `t/ ld` or `t/ Gold Premium` will not.

- **Filtering by Income (Using Comparison Operators):**
Filtering by income allows numeric comparisons using operators `=`, `>`, or `<` to find customers whose income meets certain criteria.

  - **Equal to (`=`):**  
  Use `=` to find customers with a specific income.
  Example: `i/ =5000` will match customers with an income of exactly 5000.

  - **Greater than (`>`):**  
  Use `>` to find customers with an income higher than the specified threshold.
  Example: `i/ >5000` will match customers with incomes greater than 5000.

  - **Less than (`<`):**  
  Use `<` to find customers with an income lower than the specified threshold.
  Example: `i/ <5000` will match customers with incomes below 5000.

**What to Expect:**
- **On Success:**
  - Message:
    ```
    x person(s) listed!
    ```
    where `x` is the number of matching results.
- **On Error:**
  - If no valid flags are used:
    ```
    filter: Searches for all customers whose specified field contains the given substring (case-insensitive) and displays the results in a numbered list.

    Parameters: <FLAG>/ <SEARCH TERM>
  
    Flags: n/ (name), p/ (phone), e/ (email), a/ (address), j/ (job), r/ (remarks)
  
    Example: filter n/ Alice p/ 91112222
    ```
  - If a search term fails to meet the requirements (e.g., invalid phone number length), the system will display usage hints specific to the first invalid search term.




## 5.4 General Commands

### 5.4.1 Viewing a Client's Details {#view-command}

**Purpose:** View the full details of a selected client by opening a detailed card with all available information about the client.

**Methods to View Client Details:**
- **Method 1 - Using GUI:**  
  Left-click on a specific client in the list to open the client's card and display their full details.
- **Method 2 - Using CLI:**  
  1. Use the `↑` and `↓` arrow keys to navigate through the client list in the Command Line Interface (CLI).
  2. Once the desired client is selected **(highlighted in blue)**, type the following command to open their detailed card:
     ```
     view
     ```
  - This will display the full details of the currently selected client.

> 💡 **Pro Tip:**  
> Using the CLI with the `↑` and `↓` arrow keys to select a client is a fast, keyboard-friendly way to navigate through the list. Once selected, simply type `view` to instantly display the client's details without needing to use the mouse!




### 5.4.2 Closing a Client's Details {#close-command}

**Purpose:** Close the detailed view of a client's card and return to the main client list.

**Command Format:**
```
close
```
- If a client's detailed card is currently open, this command will return you to the main list view. 
- **Note:** If no client cards are open, the `close` command is ignored.

  


### 5.4.3 Help Menu {#help-command}

**Purpose:** Provides quick access to a command summary and the user guide for AgentAssist.

**Command Format:**
```
help
```
- Opens up a dialog box that provides: 
  - **Command summary table** with command format and basic examples
  - **Hyperlink to the User Guide**




### 5.4.4 Exiting AgentAssist {#exit}

**Purpose:** Exit the application directly from the command line, providing a quick and easy way to close the program without using external controls.

**Command Format:**
```
exit
```
- The message `Terminating program…` is displayed.
- After a brief delay, the program will close, effectively exiting the application.




## 5.5 Saving Data

AgentAssist **automatically saves** all client data to your computer after each command. There's no need to manually save anything.





## 5.6 Modifying the Data File
The data in AgentAssist is automatically saved as a [JSON](https://developer.mozilla.org/en-US/docs/Learn/JavaScript/Objects/JSON) file as `[JAR file location]/data/addressbook.json`. Advanced users are welcome to update data directly by editing that data file.

> ⚠️ **Danger:**  
> If the data file format becomes invalid, AgentAssist will **discard all data** and start with an empty file on the next run. It's strongly recommended to back up the file before any manual edits.
>
> Incorrect data modifications may also cause unexpected behavior. **Only modify the data file if you're confident in doing so correctly.**


--------------------------------------------------------------------------------------------------------------------

## 6. FAQ

### How do I transfer my data to another Computer?
Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous AddressBook home folder.

### How do I change the remarks or credit card tier of an existing customer?
Use the [`edit` command](#feature-4-edit-the-existing-customer), and specify the `t/` flag for the credit card tier, and `rn/` or `ra/` for remarks.

### Why am I getting an error when trying to edit the remark of an existing customer?
Ensure that the command syntax is correct, and note that the `rn/` and `ra/` flags cannot be used together. The `rn/` flag replaces the existing remark, while `ra/` appends to the current remark.

### What do the different tier colors represent in the UI?  
Each credit card tier is visually distinguished in the UI: Gold is marked with a gold banner, Silver with a silver banner, Bronze with a bronze banner, and Reject with a red banner. This makes it easy to see at a glance the tier of each customer.

--------------------------------------------------------------------------------------------------------------------

## 7. Known issues

1. **When using multiple screens**, if you move the application to a secondary screen, and later switch to using only the primary screen, the GUI will open off-screen. The remedy is to delete the `preferences.json` file created by the application before running the application again.
2. **If you minimize the Help Window** and then run the `help` command (or use the `Help` menu, or the keyboard shortcut `F1`) again, the original Help Window will remain minimized, and no new Help Window will appear. The remedy is to manually restore the minimized Help Window.

--------------------------------------------------------------------------------------------------------------------

## 8. Command Summary

| **Action**                 | **Command Format**                                                                                                           | **Example**                                                                                               |
|----------------------------|------------------------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------|
| **Add New Client**         | `add n/<NAME> p/<PHONE> e/<EMAIL> a/<ADDRESS> j/<JOB> i/<INCOME> [t/<TIER>] [rn/<REMARK>]`                                   | `add n/ GORDON MOORE p/ 99007766 e/ gmoore@ntu.sg a/ COM3 j/ engineer i/ 99999 t/ gold rn/ remark`        |
| **Delete Existing Client** | `delete <INDEX>`                                                                                                             | `delete 69`                                                                                               |
| **Edit Existing Client**   | `edit <INDEX> n/<NAME> p/<PHONE> e/<EMAIL> a/<ADDRESS> j/<JOB> i/<INCOME> [t/<TIER>] [rn/<NEW REMARK>] [ra/<APPEND REMARK>]` | `edit 69 n/ GORDON MOORE p/ 77337733 e/ gmoore_new@ntu.sg a/ COM3 j/ doctor i/ 1000000000 ra/ added info` |
| **List All Clients**       | `list`                                                                                                                       | `list`                                                                                                    |
| **Filter Client List**     | `filter n/<NAME> p/<PHONE> e/<EMAIL> a/<ADDRESS> j/<JOB> r/<REMARK> t/<TIER> i/<INCOME>`                                     | `filter n/ GORDON MOORE j/ doctor t/ gold`                                                                |
| **View Client Details**    | `view`                                                                                                                       | `view`                                                                                                    |
| **Close Client Details**   | `close`                                                                                                                      | `close`                                                                                                   |
| **View Help**              | `help`                                                                                                                       | `help`                                                                                                    |
| **Exit Application**       | `exit`                                                                                                                       | `exit`                                                                                                    |
| **Clear All Data**         | `clear`                                                                                                                      | `clear`                                                                                                   |



